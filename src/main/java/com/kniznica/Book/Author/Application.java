package com.kniznica.Book.Author;

import com.kniznica.Book.Author.author.domain.Author;
import com.kniznica.Book.Author.author.domain.AuthorRepository;
import com.kniznica.Book.Author.author.service.AuthorService;
import com.kniznica.Book.Author.book.domain.Book;
import com.kniznica.Book.Author.book.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@SpringBootApplication
public class Application {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorService authorService;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	ApplicationRunner appStarted() {
		return args -> {
			Author ivan = this.authorRepository.save(createAuthor("Ivan"));
			this.authorRepository.save(createAuthor("Luka"));
			Book book1 = this.bookRepository.save(createBook("Suma stiborova", "3q412q542-2352", "fantasy"));
			Book book2 = this.bookRepository.save(createBook("Petar Pan", "sefsfs-234", "fantasy"));
			this.authorService.addBookToAuthor(ivan.getId(), book1.getId() );
			this.authorService.addBookToAuthor(ivan.getId(), book2.getId() );
			String[] imena = {"Berislav", "Bojan", "Bogdan", "Bogoljub", "Bogoslav", "Boris", "Borislav", "Borna", "Božidar", "Braslav", "Branimir", "Bratoljub",
					"Budimir", "Cvitan", "Časlav", "Dalibor", "Damir", "Danimir", "Darko", "Davor",  "Davorin", "Dobroslav", "Domagoj", "Dragutin", "Dražen", "Držislav",
					"Dubravko", "Gojko", "Gojslav", "Goran", "Gordan", "Grozdan", "Gvozdan", "Gvozden", "Hrvoje", "Istok", "Jadran", "Jagor", "Javor", "Jaroslav", "Jasen",
					"Jelen", "Ladislav", "Lav", "Lavoslav", "Lobel", "Ljuban", "Ljubomir", "Ljudevit", "Kazimir", "Klukas", "Kosjenc", "Krešimir", "Križan", "Krunoslav",
					"Krsto", "Milan", "Milivoj", "Miljenko", "Miran", "Miroslav", "Mislav", "Mladen", "Muhlo", "Nebomir", "Nedjeljko", "Nenad", "Neven", "Ninoslav",
					"Novak", "Obrad", "Ognjen", "Ostoja", "Ozren", "Perun", "Porin", "Pribislav", "Radoslav", "Radimir", "Ratimir", "Rodoljub", "Samo", "Samovlad",
					"Sandalj", "Sanjin", "Selimir", "Slavoljub", "Slavomir", "Smiljan", "Snovid", "Srećko", "Stanimir", "Stanislav", "Strahimir", "Stribor",
					"Svanimir", "Svarun", "Svebor", "Svemir", "Svetimir", "Svetislav", "Tihan", "Tihomir", "Tolimir", "Tomislav", "Trpimir", "Tugomir", "Tvrtko",
					"Vatroslav", "Većeslav", "Vedran", "Velibor", "Velimir", "Vidak", "Vidan", "Vidomir",  "Vihor", "Vilan", "Vitan", "Višemir", "Višeslav", "Vitomir",
					"Vjekoslav", "Vjenceslav", "Vjeran", "Vladan", "Vladimir", "Vladislav", "Vladko", "Vlatko", "Vojan", "Vuk", "Vukan", "Vukomir", "Vukoslav", "Zdenko",
					"Zdeslav", "Zdravko", "Zlatan", "Zoran", "Zorislav", "Zrin", "Zrinko", "Zrinoslav", "Zvjezdan", "Zvonimir", "Želimir", "Željko",
					"Biljana", "Blaženka", "Bojana", "Borjana", "Bosiljka", "Božena", "Branimira", "Branka", "Buga", "Cvijeta", "Cvita", "Damira", "Danica",
					"Davorka", "Dinara", "Divna", "Domaslava", "Draga", "Dragana", "Dragojla", "Drava", "Dražena",  "Drina", "Dubravka", "Dunja", "Gorana",
					"Gordana", "Grozdana", "Hrvojka", "Ivančica", "Iskra", "Jadranka", "Jagoda", "Jasmina", "Jasna", "Jelena", "Korana", "Kosjenka",
					"Krešimira", "Krunoslava", "Lada", "Lela", "Lijepa", "Lika", "Ljerka", "Ljiljana", "Ljuba", "Ljubica", "Ljupka", "Lovorka", "Mila",
					"Milana", "Milena", "Milica", "Mirna", "Miroslava", "Morana", "Nada", "Neda", "Nedjeljka", "Nevenka", "Ruža", "Sanja", "Slava",
					"Slavomira", "Smiljana", "Snježana", "Srebrenka", "Srna", "Svjetlana", "Sunčana", "Sunčica", "Tihana", "Tomislava", "Tuga",
					"Una", "Vanda", "Vedrana", "Vjera", "Vesna", "Vila", "Vilina", "Vida", "Vidra", "Višnja", "Vitača", "Vladimira", "Vladislava",
					"Vladka", "Vlatka", "Vlasta", "Vojača", "Zarja", "Zdravka", "Zdenka", "Zlatka", "Zorana", "Zorja", "Zrina", "Zrinka", "Zvjezdana",
					"Zvonimira", "Željana" };
			for (String i:imena) {
				this.authorRepository.save(createAuthor(i));
			}
			String[] knigeIme14 = {"Maigret – Obješeni sa Saint-Pholiena", "Opasni biseri,Zavirivanje", "U ime mafije", "Spaljeni novac",
					"Trideset jedno i pol kajanje", "Put u prašnjavu smrt", "Moja voljena žena", "A Feast for Crows", "A Storm of Swords",
					"Kula tmine II", "Završnica – Poziv", "The Dark Tower III: The Waste Lands", "Time’s Dark Laughter", "Firethorn"  };
			String[] isbn14 = { "eerge4--342342fv","fbdfdx4w-re5rxcs", "fdfhdr-t2342342", "32342d-xfsdasc", "fvsrf2-32rascf0", "dcsdc-s124241",
			"fv54tz-45znfgnf", "324235-gfbrtmju", "g45z65r-uvbd-2", "36z45zfbd-sdfsvs-145", "efwfwe0-98070fwef", "fbb097-89ashhoi","dgvfv-df56756", "efwefwsv-sdv3343"};

			for(int i =0; i < 14; i++){
				bookRepository.save(createBook(knigeIme14[i],isbn14[i],"crime" ));
				authorService.addBookToAuthor((long) (i+2), (long) (i+2));
			}





		};
	}

	private Author createAuthor(String name) {
		Author author = new Author();
		author.setName(name);
		return author;
	}


	private Book createBook(String title, String isbn, String genre){
		return new Book(title,isbn,genre);

	}

}
