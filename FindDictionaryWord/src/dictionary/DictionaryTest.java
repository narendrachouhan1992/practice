package dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryTest {
	static int R = 3;
	static int C = 13;
	int[] moveX = {1, 1, 1, 0, 0, -1, -1, -1};
	int[] moveY = {0, 1, -1, 1, -1, -1, 0, -1};
	boolean isValid(int i, int j)
	{
		return (i<R && i>=0 && j<C &&  j>=0);
	}
	void printDictionAryWord(char[][] arr)
	{
		for(int i=0;i<R;i++)
		{
			for(int j=0;j<C;j++)
			{
				for(int k =0;k<8;k++)
				{
					String s = Character.toString(arr[i][j]);
					int it = i;
					int jt = j;
					if(Trie.getDict().findWord(s))
						System.out.println(s);
					while(isValid(it+moveX[k], jt+moveY[k]))
					{
						it += moveX[k];
						jt += moveY[k];
						s += Character.toString(arr[it][jt]);
						if(Trie.getDict().findWord(s))
							System.out.println(s);
					}
				}
				
			}
		}
	}
	public static void main(String[] args) {
		File file = new File("D:\\eclipse_new\\FindDictionaryWord\\src\\dictionary\\english.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st = br.readLine();
			while (st != null) {
				Trie.getDict().addWord(st);
				st = br.readLine();
			}
			char[][] arr = {"GEEKSFORGEEKS".toCharArray(),
		                       "GEEKSQUIZGEEK".toCharArray(),
		                       "IDEQAPRACTICE".toCharArray()
		                      };
			DictionaryTest obj = new DictionaryTest();
			obj.printDictionAryWord(arr);
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
}
