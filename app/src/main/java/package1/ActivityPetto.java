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

public class ActivityPetto extends AppCompatActivity {

    private RecyclerViewAdapterSpieg recyclerViewAdapterSpieg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addome);
        List<Exsc> exscList=new ArrayList<Exsc>();
        View view=getLayoutInflater().inflate(R.layout.listesercizi,null);
        exscList.add(new Exsc("Bench Press","1. Sdraiati su una panca piana. Usando una presa di larghezza media (una presa che crea un angolo di 90 gradi nel mezzo del movimento tra gli avambracci e la parte superiore delle braccia), solleva la barra dal rack e tienila dritta sopra di te con le braccia bloccate. Questa sarà la tua posizione iniziale.\n" +
                "\n 2. Dalla posizione di partenza, inspira e inizia a scendere lentamente finché la barra non tocca il centro del torace.\n" +
                "\n 3. Dopo una breve pausa, spingi la barra nella posizione di partenza mentre espiri. Concentrati sulla spinta della barra usando i muscoli del torace. Blocca le braccia e stringi il petto nella posizione contratta nella parte superiore del movimento, mantieni la posizione per un secondo e poi ricomincia a scendere lentamente. Suggerimento: idealmente, abbassare il peso dovrebbe richiedere circa il doppio del tempo necessario per sollevarlo.\n" +
                "\n 4. Ripetere il movimento per la quantità prescritta di ripetizioni.\n" +
                "\n 5. Quando hai finito, rimetti la barra nel rack.\n" +
                "\n" +
                "Attenzione:\n" +
                "\n" +
                "Se sei nuovo in questo esercizio, ti consigliamo di utilizzare uno spotter. Se non è disponibile alcuno spotter, sii prudente con la quantità di peso utilizzata.\n" +
                "\n",R.drawable.benchpress,"https://www.youtube.com/watch?v=gRVjAtPip0Y"));
        exscList.add(new Exsc("Dumbbell Bench Press","1. Sdraiati su una panca piana con un manubrio in ogni mano appoggiato sopra le cosce. I palmi delle tue mani saranno uno di fronte all'altro.\n" +
                "\n 2. Quindi, usando le cosce per aiutare a sollevare i manubri, solleva i manubri uno alla volta in modo da poterli tenere davanti a te alla larghezza delle spalle.\n" +
                "\n 3. Una volta alla larghezza delle spalle, ruota i polsi in avanti in modo che i palmi delle mani siano rivolti lontano da te. I manubri dovrebbero trovarsi appena ai lati del petto, con la parte superiore del braccio e l'avambraccio che creano un angolo di 90 gradi. Assicurati di mantenere sempre il pieno controllo dei manubri. Questa sarà la tua posizione iniziale.\n" +
                "\n 4. Quindi, mentre espiri, usa il petto per sollevare i manubri. Blocca le braccia nella parte superiore dell'ascensore e stringi il petto, mantieni la posizione per un secondo e poi inizia a scendere lentamente. Suggerimento: idealmente, abbassare il peso dovrebbe richiedere circa il doppio del tempo necessario per sollevarlo.\n" +
                "\n 5. Ripeti il movimento per la quantità prescritta di ripetizioni del tuo programma di allenamento.\n" +
                "\n" +
                "Attenzione: quando hai finito, non far cadere i manubri accanto a te poiché questo è pericoloso per la tua cuffia dei rotatori nelle spalle e per gli altri che si allenano intorno a te.",R.drawable.dumbellbench,"https://www.youtube.com/watch?v=5n9TlaoRD58"));
        exscList.add(new Exsc("Pushups","1. Sdraiati sul pavimento a faccia in giù e metti le mani a circa 36 pollici di distanza mentre tieni il busto alla lunghezza delle braccia.\n" +
                "\n 2. Quindi, abbassati verso il basso finché il tuo petto non tocca quasi il pavimento mentre inspiri.\n" +
                "\n 3. Ora espira e spingi la parte superiore del corpo indietro fino alla posizione di partenza mentre stringi il petto.\n" +
                "\n 4. Dopo una breve pausa nella posizione contratta in alto, puoi ricominciare ad abbassarti verso il basso per tutte le ripetizioni necessarie.\n" +
                "\n" +
                "Variazioni:\n" +
                "\n" +
                "Se sei nuovo in questo esercizio e non hai la forza per eseguirlo, puoi piegare le gambe sulle ginocchia per eliminare la resistenza o eseguire l'esercizio contro il muro invece che sul pavimento.\n" +
                "\n" +
                "Per i sollevatori più avanzati, puoi posizionare i piedi su una superficie alta come una panca per aumentare la resistenza e mirare maggiormente alla parte superiore del torace.",R.drawable.pushups,"https://www.youtube.com/watch?v=IODxDxX7oi4"));
        exscList.add(new Exsc("Dumbbell Flyes","1. Sdraiati su una panca piana con un manubrio su ogni mano appoggiato sopra le cosce. I palmi delle tue mani saranno uno di fronte all'altro.\n" +
                "\n 2. Quindi, usando le cosce per aiutare a sollevare i manubri, solleva i manubri uno alla volta in modo da poterli tenere davanti a te alla larghezza delle spalle con i palmi delle mani uno di fronte all'altro. Alza i manubri come se li stessi premendo, ma fermati e mantieni la posizione appena prima di bloccarti. Questa sarà la tua posizione iniziale.\n" +
                "\n 3. Piegando leggermente i gomiti per evitare sollecitazioni al tendine del bicipite, abbassa le braccia su entrambi i lati in un ampio arco finché non senti un allungamento sul petto. Inspira mentre esegui questa parte del movimento. Suggerimento: tieni presente che durante tutto il movimento le braccia devono rimanere ferme; il movimento dovrebbe avvenire solo all'articolazione della spalla.\n" +
                "\n 4. Riporta le braccia nella posizione di partenza mentre stringi i muscoli del torace ed espiri. Suggerimento: assicurati di utilizzare lo stesso arco di movimento utilizzato per abbassare i pesi.\n" +
                "\n 5. Mantieni la posizione contratta per un secondo e ripeti il movimento per il numero prescritto di ripetizioni.\n" +
                "\n" +
                "Variazioni: potresti voler utilizzare una versione con i palmi rivolti in avanti per una stimolazione diversa.",R.drawable.dumbellflyes,"https://www.youtube.com/watch?v=eozdVDA78K0"));
        exscList.add(new Exsc("Chest dip","1. Per questo esercizio avrai bisogno di accedere alle barre parallele. Per metterti nella posizione di partenza, tieni il corpo a braccia tese (braccia bloccate) sopra le sbarre.\n" +
                "\n 2. Mentre inspiri, abbassati lentamente con il busto inclinato in avanti di circa 30 gradi e i gomiti leggermente allargati fino a sentire un leggero allungamento nel petto.\n" +
                "\n 3. Una volta che senti l'allungamento, usa il petto per riportare il corpo nella posizione di partenza mentre espiri. Suggerimento: ricorda di stringere il petto nella parte superiore del movimento per un secondo.\n" +
                "\n 4. Ripetere il movimento per la quantità prescritta di ripetizioni.\n" +
                "\n" +
                "Variazioni:\n" +
                "\n" +
                "Se sei nuovo in questo esercizio e non hai la forza per eseguirlo, usa una macchina dip assist se disponibile. Queste macchine usano il peso per aiutarti a spingere il tuo peso corporeo.\n" +
                "\n" +
                "Altrimenti, uno spotter che ti tiene le gambe può aiutarti.\n" +
                "\n" +
                "I sollevatori più avanzati possono aggiungere peso all'esercizio utilizzando una cintura di peso che consente l'aggiunta di piastre ponderate.",R.drawable.chestdip,"https://www.youtube.com/watch?v=dX_nSOOJIsE"));
        RecyclerView recyclerView=findViewById(R.id.recyclerviewsp);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapterSpieg=new RecyclerViewAdapterSpieg(this,exscList);
        recyclerView.setAdapter(recyclerViewAdapterSpieg);
    }
}