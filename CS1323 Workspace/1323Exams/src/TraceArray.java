
public class TraceArray 
{
   public static void main(String[] args)
   {
	   int[] data = new int[3];
	   for (int i = 0; i < data.length; ++i)
		   data[i] = 2 * i + 1;
	   
	   int size = 5;
	   
	   data = mystery(size, data);
	   
	   for(int j = 0; j < data.length; ++j)
		   System.out.print(data[j]);
   }
   
   private static int[] mystery(int count, int[] initial)
   {
	   int[] result = new int[count];
	   int fill = -1;
	   
	   for(int i = 0; i < count; ++i)
	   {
		   if (count < initial.length)
			   result[i] = initial[i];
		   else
			   result[i] = fill;
	   }
	   
	   return result;
   }
}
