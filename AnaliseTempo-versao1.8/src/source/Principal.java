package source;



public class Principal {
	
	public int[] constroiLista(int tamanho) {
		int lista[] = new int[tamanho];
		for(int x=tamanho,y=0;x>0;x--,y++) {
			lista[y]=x;
		}
		return lista;
	}
	
	public void imprimeLista(long[] lista) {
		for(int x=0;x<lista.length;x++) {
			System.out.print(lista[x]+" ");
		}
		System.out.println();
	}
	
	public void imprimeLista(int[] lista) {
		for(int x=0;x<lista.length;x++) {
			System.out.print(lista[x]+" ");
		}
		System.out.println();
	}
	
	void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
	
	public void selectionSort(int array[]) {
		int n = array.length;
		for(int x=0; x<n; x++)
			 
		{
		 
		    int index_of_min = x;
		 
		    for(int y=x; y<n; y++)
		 
		    {
		 
		        if(array[index_of_min]>array[y])
		 
		        {
		 
		            index_of_min = y;
		 
		        }
		 
		    }
		 
		    int temp = array[x];
		 
		    array[x] = array[index_of_min];
		 
		    array[index_of_min] = temp;
		 
		}
	}
	
	public long[] executeSelection() {
		Principal programa = new Principal();
		long tempos[] = new long[1000];
		for(int x=1;x<=1000;x++) {
			int l[] = programa.constroiLista(x);		
			long ini = System.nanoTime();
			programa.selectionSort(l);
			long fim = System.nanoTime();
			tempos[x-1]=fim-ini;
		}
		//programa.imprimeLista(tempos);

		return tempos;
	}

	public long[] executeBubble() {
		Principal programa = new Principal();
		long tempos[] = new long[1000];
		for(int x=1;x<=1000;x++) {
			int l[] = programa.constroiLista(x);		
			long ini = System.nanoTime();
			programa.bubbleSort(l);
			long fim = System.nanoTime();
			tempos[x-1]=fim-ini;
		}
		//programa.imprimeLista(tempos);

		return tempos;
	}

}

