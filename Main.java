import banca.data.Database;
import banca.data.FileSystemDatabase;
import banca.domain.Impiegato;

public class Main {
  public static void main(String[] args) {
		Database database = new FileSystemDatabase("impiegati.txt", ",");
		Iterable<Impiegato> imps = database.getAllEmployees(); 
		for ( Impiegato i : imps ) {
			System.out.println(i);
		}

  }
}