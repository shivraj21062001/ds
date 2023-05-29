import mpi.*;

public class DistributedSum {
    public static void main(String[] args) throws MPIException {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int[] array  = {1,2,3,4,5,6,7,8,9,10};
        int n = array.length;
        int no = n/size;
        int remender = n%size;

        int[] local_array = new int[ no+(rank<remender?1:0)];

        int offset = no*rank+Math.min(rank, remender);
        System.out.println("offset is "+offset);

        for (int i = 0; i < local_array.length; i++) {
            local_array[i]=array[i+offset];
        }
        int local_sum=0;

        for (int i = 0; i < local_array.length; i++) {
            local_sum+=local_array[i];
        }

        int[] globle_sum = new int[size];

        MPI.COMM_WORLD.Allgather(new int[]{local_sum},0,1,MPI.INT,globle_sum,0,1,MPI.INT);

        if(rank==0){
            int t=0;
            for(int i=0; i<size;i++){
                t+=globle_sum[i];
            }
            System.out.println(t);
        }

        MPI.Finalize();

    }
}
