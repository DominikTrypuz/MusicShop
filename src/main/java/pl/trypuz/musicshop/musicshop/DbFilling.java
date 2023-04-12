//package pl.trypuz.musicshop.musicshop;
//
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//import pl.trypuz.musicshop.musicshop.api.Controller;
//import pl.trypuz.musicshop.musicshop.model.AlbumDTO;
//
//@Component
//public class DbFilling {
//
//    private final Controller controller;
//
//    public DbFilling(Controller controller) {
//        this.controller = controller;
//    }
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void doSomethingAfterStartup() {
//        controller.save(new AlbumDTO(
//                "AC/DC",
//                "Back in Black",
//                "https://upload.wikimedia.org/wikipedia/commons/b/be/Acdc_backinblack_cover.jpg",
//                "\"Back in Black\" to siódmy studyjny album zespołu AC/DC, wydany w 1980 roku. " +
//                        "Jest to jednocześnie pierwszy album nagrany po śmierci wokalisty Bon Scotta, który zmarł w 1980 roku. " +
//                        "Wokalistą na albumie został Brian Johnson. " +
//                        "AlbumEntity \"Back in Black\" jest uważany za jedną z największych płyt w historii rocka i jedno z najlepszych osiągnięć zespołu AC/DC. " +
//                        "Jest to klasyczny album rockowy, który charakteryzuje się potężnym brzmieniem gitary i energetycznymi wokalami. " +
//                        "AlbumEntity otwiera tytułowy utwór \"Back in Black\", który stał się jednym z najbardziej rozpoznawalnych utworów AC/DC. " +
//                        "Następne utwory, takie jak \"Hells Bells\" i \"Shoot to Thrill\", " +
//                        "również są bardzo popularne i stanowią przykłady ciężkiego rocka z charakterystycznymi riffami gitarowymi. " +
//                        "Jednym z najbardziej znanych utworów na albumie jest ballada \"You Shook Me All Night Long\", " +
//                        "która została ogromnym hitem i nadal jest jednym z najczęściej granych utworów AC/DC. AlbumEntity \"Back in Black\" " +
//                        "zawiera również kilka mniej znanych utworów, takich jak \"Rock and Roll Ain't \n" +
//                        "Noite Pollution\" i \"Let Me Put My Love Into You\", które również są przykładami potężnego brzmienia i energii, " +
//                        "charakterystycznej dla AC/DC. W skrócie, \"Back in Black\" to album, który definiuje brzmienie AC/DC i rocka w ogóle. " +
//                        "Zawiera on wiele klasycznych utworów, które nadal cieszą się ogromną popularnością i wpłynęły na wielu muzyków na całym świecie.",
//                "Rock",
//                "25 lipca 1980",
//                "Atlantic Records"
//        ));
//        controller.save(new AlbumDTO(
//                "DŻEM",
//                "Najemnik",
//                "https://www.dzem.com.pl/dyskografia/img/600/najemnik-600.jpg",
//                "\"Najemnik\" to piąty album studyjny zespołu Dżem, wydany w 1986 roku. " +
//                        "Jest to jeden z najbardziej znanych i cenionych albumów zespołu, który przyniósł mu ogromną popularność i uznanie. " +
//                        "AlbumEntity \"Najemnik\" to mieszanka różnych stylów muzycznych, w tym bluesa, rocka, soulu i jazzu. " +
//                        "Teksty utworów są bardzo emocjonalne i poruszające ważne tematy społeczne, takie jak ubóstwo, samotność i brak nadziei. " +
//                        "AlbumEntity otwiera utwór \"Czerwony jak cegła\", który ma potężne brzmienie gitarowe i energetyczną melodię. " +
//                        "Następnie album przechodzi do utworów takich jak \"List do M\", \"Najemnik\" i \"Wehikuł czasu\", " +
//                        "które są przykładami blues-rocka z wyraźnymi elementami soulu i jazzu. " +
//                        "Jednym z najbardziej znanych utworów na albumie jest \"Whisky\", która stała się jednym z największych przebojów zespołu. " +
//                        "Inne wyróżniające się utwory to ballady \"Kiepska gra\" i \"Wokół sami lunatycy\", " +
//                        "a także ostrzejsze utwory jak \"Smutna niedziela\" i \"Paw\". \"Najemnik\" to album, " +
//                        "który ugruntował pozycję Dżemu jako jednego z najlepszych polskich zespołów \n" +
//                        "rockowych. Zawiera on wiele klasycznych utworów, które do dziś cieszą się ogromną popularnością i są często wykonywane na koncertach. " +
//                        "To album, który każdy miłośnik polskiego rocka powinien znać i docenić.",
//                "Blues",
//                "20-23 maja, 13-15 września 1988",
//                "Atomica"
//        ));
//        controller.save(new AlbumDTO(
//                "METALLICA",
//                "Hardwired...To Self-Destruct",
//                "https://www.musicmaniarecords.be/media/og-image/92244-hardwired...to-selfdestruct.jpg",
//                "\"Hardwired... to Self-Destruct\" to dziesiąty studyjny album amerykańskiej grupy heavy metalowej Metallica, " +
//                        "wydany 18 listopada 2016 roku. AlbumEntity składa się z dwóch płyt, na których znajduje się łącznie dwanaście utworów. " +
//                        "AlbumEntity zaczyna się dynamicznym utworem tytułowym \"Hardwired\", który wprowadza słuchacza w energetyczny i agresywny klimat. " +
//                        "Następnie słychać utwór \"Atlas, Rise!\", który odwołuje się do klasycznego stylu zespołu z czasów albumów takich " +
//                        "jak \"Master of Puppets\" czy \"Ride the Lightning\". Wśród utworów na albumie można znaleźć również balladę \"Halo on Fire\", " +
//                        "która wyróżnia się spokojniejszym tempem i melodyjną linią wokalną. Kolejne utwory, takie jak \"Now That We're Dead\" " +
//                        "i \"Moth into Flame\", prezentują bardziej szybkie i agresywne brzmienia. Teksty utworów na albumie często odnoszą się do tematów " +
//                        "związanych z konfliktem wewnętrznym, emocjonalnymi trudnościami i przeciwnościami, z którymi boryka się każdy człowiek. " +
//                        "AlbumEntity zawiera także krytykę systemu politycznego i społecznego w utworach takich jak \"Spit Out the Bone\" czy \"Dream No More\". " +
//                        "Ogólnie rzecz biorąc, \"Hardwired... to Self-Destruct\" to album, który przynosi fanom Metallica to, " +
//                        "czego można się spodziewać po tym zespole - energiczne, agresywne i melodyjne utwory, oparte na charakterystycznym stylu gry " +
//                        "gitarowej i wokalu Jamesa Hetfielda.",
//                "Metal",
//                "18 listopada 2016",
//                "Blackened Recordings"
//        ));
//        controller.save(new AlbumDTO(
//                "METALLICA",
//                "Ride the Lightning",
//                "https://i.etsystatic.com/19416137/r/il/18276f/3309104635/il_fullxfull.3309104635_d4nu.jpg",
//                "drugi album studyjny amerykańskiego zespołu thrashmetalowego Metallica. Został wydany 27 lipca 1984 roku przez wytwórnię " +
//                        "Megaforce Records. Jest to drugie i ostatnie wydawnictwo zespołu dla tej wytwórni, od której grupa odeszła za namową menadżera, " +
//                        "Cliffa Burnsteina z QPrime Management, które wypromowało między innymi AC/DC, Aerosmith, i Scorpionsów. We wrześniu 1984 Metallica " +
//                        "podpisała kontrakt z wytwórnią Elektra, która dwa miesiące później wydała reedycję albumu",
//                "Metal",
//                "27 lipca 1984",
//                "Megaforce, Elektra, Music for Nations"
//        ));
//    }
//}
