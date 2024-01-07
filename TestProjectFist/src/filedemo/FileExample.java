package filedemo;


	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
	public class FileExample {
		public static void main(String[] args) {
			File file = new File("sample1.txt");
			System.out.println(file.getAbsolutePath());
			System.out.println("File exists? " + file.exists());
			// . means the current directory
			// .. mean the parent directory
			File dir = new File("C:\\Users\\eric\\development\\2023-RTT-81\\into-to-java\\FirstProject");
			System.out.println(dir.getAbsolutePath());
			File parent = new File("..\\..\\..\\..\\..\\..\\..");
			System.out.println("Parent directory " + parent.getAbsolutePath());
			for (File f : parent.listFiles()) {
				System.out.println(f.getName());
			}
			try {
				PrintWriter writer = new PrintWriter(new FileWriter(file, true));
				writer.append("This is the java class file number 2\n");
				writer.write("This is a write");
				writer.flush();
				writer.close();
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		}


}
