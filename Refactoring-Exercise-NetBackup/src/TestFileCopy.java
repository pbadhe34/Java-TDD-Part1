import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestFileCopy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File srcFile = new File("C:/source/message.txt");

		// real file backup code
		String fname = srcFile.getName();
		System.out.println("The file name is  " + srcFile.getName());
		/*System.out.println("The file absolute path  is  "
				+ srcFile.getAbsolutePath());
*/
		File backFile = new File("d:\\Data\\" + fname);
		/*System.out.println("The backed file new path is  "
				+ backFile.getAbsolutePath());*/
		boolean isCreated = false;
		try {
			//backFile.delete();
			isCreated = backFile.createNewFile();
		} catch (IOException e) {
			System.out.println("Error in creating new file " + e.getMessage());
		}
		if (isCreated) {
			System.out.println("The file  " + fname + " is backed up ");
			System.out.println("Copying the contents");
			try {
				FileInputStream fis = new FileInputStream(srcFile);
				int size = fis.available();
				System.out.println("The src file contents size is  " + size);
				byte contents[] = new byte[size];
				fis.close();
				
				DataOutputStream oStream = new DataOutputStream(
						new FileOutputStream(backFile));
				DataInputStream iStream = new DataInputStream(new FileInputStream(srcFile));

				//int bytesRead = iStream.read(contents);
				String data = iStream.readLine();
				System.out
						.println("The number of bytes read are  " + data.length());
				oStream.writeBytes(data);

				System.out.println("The number of bytes wrote are  ");
				iStream.close();
				oStream.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
