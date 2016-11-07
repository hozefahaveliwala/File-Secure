import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class Test {
	public static void main(String arg[]) throws ParserConfigurationException,
			SAXException, IOException {

		Parameters pp = new Parameters();

		String key = "M=ry^h*s &ne#x;t";

		String epath, efilename, dpath, dfilename, ipath, ifilename;

		File inputFile;
		File encryptedFile;
		File dencryptedFile;

		ipath = pp.getinputfilepath();
		ifilename = pp.getInputfilename();
		epath = pp.getEncryptedfilepath();
		dpath = pp.getDencryptedfilepath();
		efilename = pp.getEncryptedfilename();
		dfilename = pp.getDencryptedfilename();

		if (pp.getMode().equalsIgnoreCase("e")) {

			if (ipath.isEmpty() == false) {
				if (ifilename.isEmpty() == false) {
					inputFile = new File(ipath + File.separator + ifilename);

					if (epath.isEmpty() == true) {
						epath = ipath;
					}
					if (efilename.isEmpty() == true) {
						efilename = ifilename;
					}

					encryptedFile = new File(epath + File.separator + efilename);
					Encrypt.encrypt(key, inputFile, encryptedFile);
					System.out.println("Encryption Successful");
				} else {
					System.out.println("inputfilename empty");
				}
			} else {
				System.out.println("inputpath empty");
			}

		} else if (pp.getMode().equalsIgnoreCase("d")) {

			if (epath.isEmpty() == false) {
				if (efilename.isEmpty() == false) {
					encryptedFile = new File(epath + File.separator + efilename);
					if (dpath.isEmpty() == true) {
						dpath = epath;
					}
					if (dfilename.isEmpty() == true) {
						dfilename = efilename;
					}

					dencryptedFile = new File(dpath + File.separator
							+ dfilename);

					Encrypt.decrypt(key, encryptedFile, dencryptedFile);
					System.out.println("Decryption Successful");
					
				} else {
					System.out.println("encryptedfilename empty");
				}
			} else {
				System.out.println("encryptedfilepath empty");
			}

		} else {
			System.out.println("Mode Incorrect..");
		}
	}
}
