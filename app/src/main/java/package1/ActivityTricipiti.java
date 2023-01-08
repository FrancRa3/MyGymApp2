package package1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import provaembrionale.Adapteres;
import ItemsClassi.Exsc;
import ui.RecyclerViewAdapterSpieg;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityTricipiti extends AppCompatActivity {

    private RecyclerViewAdapterSpieg recyclerViewAdapterSpieg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addome);
        List<Exsc> exscList=new ArrayList<Exsc>();
        View view=getLayoutInflater().inflate(R.layout.listesercizi,null);
        exscList.add(new Exsc("Triceps dip","1. Per entrare nella posizione di partenza, tieni il corpo a distanza di un braccio con le braccia quasi bloccate sopra le sbarre.\n" +
                "\n 2. Ora, inspira e abbassati lentamente verso il basso. Il tuo busto dovrebbe rimanere eretto e i gomiti dovrebbero stare vicino al tuo corpo. Questo aiuta a concentrarsi meglio sul coinvolgimento del tricipite. Abbassati finché non si forma un angolo di 90 gradi tra la parte superiore del braccio e l'avambraccio.\n" +
                "\n 3. Quindi, espira e spingi indietro il busto usando i tricipiti per riportare il corpo nella posizione di partenza.\n" +
                "\n 4. Ripetere il movimento per la quantità prescritta di ripetizioni.\n" +
                "\n" +
                "Variazioni: se sei nuovo in questo esercizio e non hai la forza per eseguirlo, usa una macchina dip assist se disponibile. Queste macchine usano il peso per aiutarti a spingere il tuo peso corporeo.",R.drawable.tricepsdip,"https://www.youtube.com/watch?v=T1L4smOP0L8"));
        exscList.add(new Exsc("Decline EZ-bar skullcrusher","1. Fissa le gambe alla fine della panca declinata e sdraiati lentamente sulla panca.\n" +
                "\n 2. Usando una presa stretta (una presa leggermente inferiore alla larghezza delle spalle), solleva la barra EZ dal rack e tienila dritta sopra di te con le braccia bloccate e i gomiti in dentro. Le braccia dovrebbero essere perpendicolari al pavimento. Questa sarà la tua posizione iniziale. Suggerimento: per proteggere la cuffia dei rotatori, è meglio che uno spotter ti aiuti a sollevare il bilanciere dal rack.\n" +
                "\n 3. Mentre inspiri e mantieni ferma la parte superiore delle braccia, abbassa lentamente la barra muovendo gli avambracci con un movimento semicircolare verso di te finché non senti la barra toccare leggermente la tua fronte. Inspira mentre esegui questa parte del movimento.\n" +
                "\n 4. Riporta la barra nella posizione di partenza contraendo i tricipiti ed espirando.\n" +
                "\n 5. Ripeti fino a quando non viene eseguita la quantità raccomandata di ripetizioni.\n" +
                "\n" +
                "Variazioni: puoi usare una barra dritta o dei manubri per eseguire questo movimento. Puoi anche eseguirlo su una panca piana.",R.drawable.declinedtriceps,"https://www.youtube.com/watch?v=OpRLGph7El8"));
        exscList.add(new Exsc("Cable V-bar push-down","1. Attacca una barra a V a una puleggia alta e afferra con una presa prona (i palmi rivolti verso il basso) alla larghezza delle spalle.\n" +
                "\n 2. In posizione eretta con il busto dritto e una piccolissima inclinazione in avanti, porta la parte superiore delle braccia vicino al corpo e perpendicolare al pavimento. Gli avambracci dovrebbero essere rivolti verso la puleggia mentre tengono la barra. I pollici dovrebbero essere più alti del mignolo. Questa è la tua posizione di partenza.\n" +
                "\n 3. Usando i tricipiti, abbassa la barra finché non tocca la parte anteriore delle cosce e le braccia sono completamente distese perpendicolarmente al pavimento. La parte superiore delle braccia dovrebbe rimanere sempre ferma accanto al busto e solo gli avambracci dovrebbero muoversi. Espira mentre esegui questo movimento.\n" +
                "\n 4. Dopo una seconda presa nella posizione contratta, porta lentamente la V-Bar fino al punto di partenza. Inspira mentre esegui questo passaggio.\n" +
                "\n 5. Ripeti per la quantità raccomandata di ripetizioni.\n" +
                "\n" +
                "Variazioni: ci sono molte varianti a questo movimento. Ad esempio, puoi utilizzare un attacco barra E-Z e un attacco barra cavo dritto per diverse varianti dell'esercizio. Inoltre, puoi attaccare una corda alla puleggia e utilizzare una presa inversa sugli esercizi della barra.",R.drawable.cabletriceps,"https://www.youtube.com/watch?v=2-LAMcpzODU"));
        exscList.add(new Exsc("Weighted bench dip","1. Per questo esercizio dovrai posizionare una panca dietro la schiena e un'altra davanti a te. Con le panche perpendicolari al corpo, aggrappati a una panca sul bordo con le mani vicine al corpo, separate alla larghezza delle spalle. Le tue braccia dovrebbero essere completamente distese.\n" +
                "\n 2. Le gambe saranno estese in avanti sopra l'altra panca. Le gambe devono essere parallele al pavimento mentre il busto deve essere perpendicolare al pavimento. Chiedi al tuo partner di posizionare il manubrio sulle tue ginocchia. Nota: questo esercizio viene eseguito al meglio con un partner poiché posizionare il peso sulle ginocchia può essere difficile e causare lesioni senza assistenza. Questa sarà la tua posizione iniziale.\n" +
                "\n 3. Abbassa lentamente il tuo corpo mentre inspiri piegando i gomiti finché non ti abbassi abbastanza da dove c'è un angolo leggermente inferiore a 90 gradi tra la parte superiore del braccio e l'avambraccio. Suggerimento: tieni i gomiti il \u200B\u200Bpiù vicino possibile durante il movimento. Gli avambracci dovrebbero essere sempre rivolti verso il basso.\n" +
                "\n 4. Usando i tricipiti per sollevare di nuovo il busto, sollevati nella posizione di partenza mentre espiri.\n" +
                "\n 5. Ripeti per la quantità raccomandata di ripetizioni.\n" +
                "\n" +
                "Attenzione: posizionando le gambe su un'altra panca piana di fronte a te, l'esercizio diventa più impegnativo. È meglio provare questo esercizio senza pesi all'inizio per abituarsi ai movimenti richiesti per una buona forma. Se anche questa variazione diventa facile, puoi chiedere a un partner di posizionare i piatti sopra le tue ginocchia. Assicurati che in questo caso il partner si assicuri che i pesi rimangano lì per tutto il movimento.",R.drawable.benchdip,"https://www.youtube.com/watch?v=c3ZGl4pAwZ4"));
        exscList.add(new Exsc("Kneeling cable triceps extension","1. Posiziona una panca lateralmente davanti a una macchina a puleggia alta.\n" +
                "\n 2. Tieni un attacco a barra dritta sopra la testa con le mani a circa 6 pollici di distanza con i palmi rivolti verso il basso.\n" +
                "\n 3. Volto lontano dalla macchina e inginocchiarsi.\n" +
                "\n 4. Metti la testa e la parte posteriore delle braccia sulla panca. I gomiti dovrebbero essere piegati con gli avambracci rivolti verso la puleggia alta. Questa sarà la tua posizione iniziale.\n" +
                "\n 5. Tenendo sempre la parte superiore delle braccia vicino alla testa con i gomiti in dentro, spingi la barra verso l'esterno con un movimento semicircolare finché i gomiti non sono bloccati e le braccia sono parallele al pavimento. Contrai con forza i tricipiti e mantieni questa posizione per un secondo. Espira mentre esegui questo movimento.\n" +
                "\n 6. Ritorna lentamente alla posizione di partenza mentre inspiri.\n" +
                "\n 7. Ripeti per la quantità raccomandata di ripetizioni.\n" +
                "\n" +
                "Variante: puoi eseguire questo esercizio anche con le bande elastiche.",R.drawable.kneetricep,"https://www.youtube.com/watch?v=mBZ4vnJRHgU"));
        RecyclerView recyclerView=findViewById(R.id.recyclerviewsp);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapterSpieg=new RecyclerViewAdapterSpieg(this,exscList);
        recyclerView.setAdapter(recyclerViewAdapterSpieg);
    }

}
