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

public class ActivitySchiena extends AppCompatActivity {

    private RecyclerViewAdapterSpieg recyclerViewAdapterSpieg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addome);
        List<Exsc> exscList=new ArrayList<Exsc>();
        View view=getLayoutInflater().inflate(R.layout.listesercizi,null);
        exscList.add(new Exsc("Trazioni","1. Afferra la barra per trazioni con i palmi rivolti in avanti utilizzando la presa prescritta. Nota sulle impugnature: per una presa ampia, le tue mani devono essere distanziate a una distanza superiore alla larghezza delle spalle. Per una presa media, le mani devono essere distanziate a una distanza pari alla larghezza delle spalle e per una presa stretta a una distanza inferiore alla larghezza delle spalle.\n" +
                "\n 2. Poiché hai entrambe le braccia distese davanti a te tenendo la barra alla larghezza di presa scelta, porta il busto indietro di circa 30 gradi mentre crei una curvatura nella parte bassa della schiena e sporgi il petto in fuori. Questa è la tua posizione di partenza.\n" +
                "\n 3. Tirare il busto verso l'alto finché la barra non tocca la parte superiore del torace tirando le spalle e la parte superiore delle braccia verso il basso e indietro. Espira mentre esegui questa parte del movimento. Suggerimento: concentrati sulla contrazione dei muscoli della schiena una volta raggiunta la posizione completamente contratta. La parte superiore del busto dovrebbe rimanere ferma mentre si muove nello spazio e solo le braccia dovrebbero muoversi. Gli avambracci non dovrebbero fare altro lavoro se non tenere la barra.\n" +
                "\n 4. Dopo un secondo in posizione contratta, inizia a inspirare e abbassa lentamente il busto nella posizione di partenza quando le braccia sono completamente distese e i dorsali sono completamente allungati.\n" +
                "\n 5. Ripeti questo movimento per la quantità prescritta di ripetizioni.\n" +
                "\n" +
                "Variazioni:\n" +
                "\n" +
                " Se sei nuovo in questo esercizio e non hai la forza per eseguirlo, usa una macchina per l'assistenza al mento, se disponibile. Queste macchine usano il peso per aiutarti a spingere il tuo peso corporeo.\n" +
                " Altrimenti, uno spotter che ti tiene le gambe può aiutarti.\n" +
                " D'altra parte, i sollevatori più avanzati possono aggiungere peso all'esercizio utilizzando una cintura di peso che consente l'aggiunta di piastre ponderate.\n" +
                " La variazione dietro il collo è sconsigliata in quanto può essere dura per la cuffia dei rotatori a causa dell'iperestensione creata portando la barra dietro il collo.\n" +
                "\n",R.drawable.trazioni,"https://www.youtube.com/watch?v=eGo4IYlbE5g"));
        exscList.add(new Exsc("Close-grip pull-down","1. Sedersi su una macchina pull-down con una barra a V attaccata alla puleggia superiore.\n" +
                "\n 2. Regola la ginocchiera della macchina per adattarla alla tua altezza. Questi cuscinetti impediranno al tuo corpo di essere sollevato dalla resistenza attaccata alla barra.\n" +
                "\n 3. Afferra la barra a V con i palmi rivolti l'uno verso l'altro (una presa neutra). Spingi il petto in fuori e inclinati leggermente all'indietro (circa 30 gradi) per coinvolgere meglio i dorsali. Questa sarà la tua posizione iniziale.\n" +
                "\n 4. Usando i dorsali, abbassa la barra mentre stringi le scapole. Continua finché il tuo petto non tocca quasi la barra a V. Espira mentre esegui questo movimento. Suggerimento: mantieni il busto fermo per tutto il movimento.\n" +
                "\n 5. Dopo una seconda presa sulla posizione contratta, riporta lentamente il bilanciere alla posizione di partenza mentre inspiri.\n" +
                "\n 6. Ripetere per il numero prescritto di ripetizioni.\n" +
                "\n" +
                "Attenzione: evita la tentazione di usare un peso così grande da dover iniziare a far oscillare il busto per eseguire l'esercizio.",R.drawable.closegripp,"https://www.youtube.com/watch?v=IjoFCmLX7z0"));
        exscList.add(new Exsc("Lat pull-down","1. Sedersi su una macchina pull-down con un'ampia barra attaccata alla puleggia superiore. Assicurati di regolare la ginocchiera della macchina per adattarla alla tua altezza. Questi cuscinetti impediranno al tuo corpo di essere sollevato dalla resistenza attaccata alla barra.\n" +
                "\n 2. Afferra la barra con i palmi rivolti in avanti usando la presa prescritta. Nota sulle impugnature: per una presa ampia, le mani devono essere distanziate a una distanza superiore alla larghezza delle spalle. Per una presa media, le mani devono essere distanziate a una distanza pari alla larghezza delle spalle e per una presa stretta a una distanza inferiore alla larghezza delle spalle.\n" +
                "\n 3. Poiché hai entrambe le braccia distese davanti a te tenendo la barra alla larghezza di presa scelta, porta il busto indietro di circa 30 gradi mentre crei una curvatura nella parte bassa della schiena e sporgi il petto in fuori. Questa è la tua posizione di partenza.\n" +
                "\n 4. Mentre espiri, abbassa la barra finché non tocca la parte superiore del torace tirando le spalle e la parte superiore delle braccia verso il basso e indietro. Suggerimento: concentrati sulla contrazione dei muscoli della schiena una volta raggiunta la posizione completamente contratta. La parte superiore del busto dovrebbe rimanere ferma e solo le braccia dovrebbero muoversi. Gli avambracci non dovrebbero fare altro lavoro se non quello di tenere la sbarra; quindi non cercare di abbassare la barra usando gli avambracci.\n" +
                "\n 5. Dopo un secondo in posizione contratta, stringendo insieme le scapole, solleva lentamente la barra nella posizione di partenza quando le braccia sono completamente distese e i dorsali sono completamente allungati. Inspira durante questa parte del movimento.\n" +
                "\n 6. Ripeti questo movimento per la quantità prescritta di ripetizioni.\n" +
                "\n" +
                "Variazioni: la variazione dietro il collo è sconsigliata in quanto può essere dura per la cuffia dei rotatori a causa dell'iperestensione creata portando la barra dietro il collo.",R.drawable.latpulldown,"https://www.youtube.com/watch?v=NL6Lqd6nU-g"));
        exscList.add(new Exsc("Straight-arm rope pull-down","1. Attacca una corda a una puleggia alta e seleziona il tuo peso. Stai un paio di piedi indietro rispetto alla puleggia con i piedi sfalsati e prendi la corda con entrambe le mani. Piegati in avanti dal fianco, mantenendo la schiena dritta, con le braccia distese davanti a te. Questa sarà la tua posizione iniziale.\n" +
                "\n 2. Tenendo le braccia tese, estendi la spalla per tirare la corda fino alle cosce.\n" +
                "\n 3. Fai una pausa alla fine del movimento, contraendo i dorsali.\n" +
                "\n 4. Ritorna alla posizione di partenza senza lasciare che il peso si appoggi completamente sulla pila.",R.drawable.ropepulldown,"https://www.youtube.com/watch?v=aXTKdnCIyWA"));
        exscList.add(new Exsc("Shotgun row","1. Attacca una singola maniglia a un cavo basso.\n" +
                "\n 2. Dopo aver selezionato il peso corretto, posizionati indietro di un paio di piedi con una posizione divaricata. Il braccio dovrebbe essere esteso e la spalla in avanti. Questa sarà la tua posizione iniziale.\n" +
                "\n 3. Eseguire il movimento ritraendo la spalla e flettendo il gomito. Mentre tiri, supina il polso, ruotando il palmo verso l'alto mentre procedi.\n" +
                "\n 4. Dopo una breve pausa, torna alla posizione di partenza.",R.drawable.shootgunrow,"https://www.youtube.com/watch?v=dcny5N6fc-g"));
        RecyclerView recyclerView=findViewById(R.id.recyclerviewsp);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapterSpieg=new RecyclerViewAdapterSpieg(this,exscList);
        recyclerView.setAdapter(recyclerViewAdapterSpieg);
    }


}