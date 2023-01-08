package package1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import ItemsClassi.Exsc;
import ui.RecyclerViewAdapterSpieg;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ActivitySpalle extends AppCompatActivity {

    private RecyclerViewAdapterSpieg recyclerViewAdapterSpieg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addome);
        List<Exsc> exscList=new ArrayList<Exsc>();
        View view=getLayoutInflater().inflate(R.layout.listesercizi,null);
        exscList.add(new Exsc("Seated Dumbbell Press","1. Prendi un paio di manubri e siediti su una panca military press o su una panca multiuso dotata di supporto per la schiena mentre posizioni i manubri in posizione verticale sopra le cosce.\n" +
                "\n 2. Pulisci i manubri uno alla volta usando le cosce per portare i manubri all'altezza delle spalle su ciascun lato.\n" +
                "\n 3. Ruota i polsi in modo che i palmi delle mani siano rivolti in avanti. Questa è la tua posizione di partenza.\n" +
                "\n 4. Mentre espiri, spingi i manubri verso l'alto finché non si toccano in alto.\n" +
                "\n 5. Dopo una seconda pausa, torna lentamente alla posizione di partenza mentre inspiri.\n" +
                "\n 6. Ripeti per la quantità raccomandata di ripetizioni.\n" +
                "\n" +
                "Variazioni:\n" +
                "\n" +
                "    Puoi eseguire l'esercizio in piedi o seduto su una normale panca piana. Per le persone con problemi lombari, la versione descritta è quella consigliata.\n" +
                "    Puoi anche eseguire l'esercizio come lo faceva Arnold Schwarzenegger, ovvero iniziare a tenere i manubri con una presa supina (palmi rivolti verso di te) davanti alle spalle e poi, mentre inizi a spingere verso l'alto, allinea i manubri nella posizione di partenza descritta al punto 3 ruotando i polsi e toccando i manubri in alto. Mentre scendi, tornerai alla posizione di partenza ruotando il polso per tutta la parte di abbassamento finché i palmi delle mani non sono rivolti verso di te. Questa variazione è chiamata Arnold Press. Tuttavia, non è raccomandato se si hanno problemi alla cuffia dei rotatori." +
                "si fa cosi cosi e cosi",R.drawable.dumbellsgiulders,"https://www.youtube.com/watch?v=qEwKCR5JCog"));
        exscList.add(new Exsc("Incline dumbbell reverse fly","1. Per iniziare, sdraiati su una panca inclinata con il petto e lo stomaco premuti contro l'inclinazione. Avere i manubri in ogni mano con i palmi rivolti l'uno verso l'altro (presa neutra).\n" +
                "\n 2. Estendi le braccia davanti a te in modo che siano perpendicolari all'angolo della panca. Le gambe dovrebbero essere ferme mentre si applica la pressione con la punta delle dita dei piedi. Questa è la posizione di partenza.\n" +
                "\n 3. Mantenendo la leggera flessione dei gomiti, sposta i pesi in fuori e lontano l'uno dall'altro (di lato) con un movimento ad arco mentre espiri. Suggerimento: prova a stringere le scapole insieme per ottenere i migliori risultati da questo esercizio.\n" +
                "\n 4. Le braccia dovrebbero essere sollevate finché non sono parallele al pavimento.\n" +
                "\n 5. Senti la contrazione e abbassa lentamente i pesi nella posizione iniziale mentre inspiri.\n" +
                "\n 6. Ripeti per la quantità raccomandata di ripetizioni.",R.drawable.dumbellflyesshoulder,"https://www.youtube.com/watch?v=buuYPLVXsJg"));
        exscList.add(new Exsc("Dumbbell front raise to lateral raise ","1. In posizione eretta, tieni un paio di manubri al tuo fianco. Questa sarà la tua posizione iniziale.\n" +
                "\n 2. Tenendo i gomiti leggermente piegati, solleva i pesi direttamente davanti a te all'altezza delle spalle, evitando oscillazioni o imbrogli.\n" +
                "\n 3. Nella parte superiore dell'esercizio, sposta i pesi davanti a te, tenendo le braccia distese.\n" +
                "\n 4. Abbassa i pesi con un movimento controllato.\n" +
                "\n 5. Nella ripetizione successiva, solleva i pesi davanti a te all'altezza delle spalle prima di spostarli lateralmente lungo i fianchi.\n" +
                "\n 6. Abbassa i pesi nella posizione di partenza.",R.drawable.frontlateralshoulders,"https://www.youtube.com/watch?v=SqTLytmDy_8"));
        exscList.add(new Exsc("Military Press","Inizia posizionando un bilanciere all'altezza del petto su uno squat rack. Dopo aver selezionato i pesi, afferra il bilanciere usando una presa pronata (i palmi rivolti in avanti). Assicurati di afferrare la barra più ampia della larghezza delle spalle l'una dall'altra.\n" +
                "    Piega leggermente le ginocchia e posiziona il bilanciere sulla clavicola. Solleva il bilanciere tenendolo appoggiato sul petto. Fai un passo indietro e posiziona i piedi alla larghezza delle spalle l'uno dall'altro.\n" +
                "    Una volta sollevato il bilanciere con la lunghezza di presa corretta, solleva il bilanciere sopra la testa bloccando le braccia. Tieni all'altezza delle spalle e leggermente davanti alla testa. Questa è la tua posizione di partenza.\n" +
                "    Abbassa lentamente la barra fino alla clavicola mentre inspiri.\n" +
                "    Solleva la barra nella posizione di partenza mentre espiri.\n" +
                "    Ripeti per la quantità raccomandata di ripetizioni.\n" +
                "\n" +
                "Variazioni:\n" +
                "\n" +
                "    Questo esercizio può essere eseguito anche da seduti poiché è meglio per chi ha problemi alla parte bassa della schiena eseguire questa varietà da seduti.\n" +
                "    La variazione dietro il collo non è raccomandata per le persone con problemi alla spalla in quanto può essere dura per la cuffia dei rotatori a causa dell'iperestensione creata portando la barra dietro il collo.\n" +
                "    Un'altra opzione è usare i manubri durante l'esecuzione di questo esercizio per un migliore isolamento.",R.drawable.military,"https://www.youtube.com/watch?v=8yVU8Oe_WlA"));
        exscList.add(new Exsc("Standing palms-in shoulder press","1. Inizia tenendo un manubrio in ogni mano con il braccio completamente esteso di lato usando una presa neutra. I tuoi piedi dovrebbero essere alla larghezza delle spalle l'uno dall'altro. Ora solleva lentamente i manubri fino a creare un angolo di 90 gradi con le braccia. Nota: gli avambracci devono essere perpendicolari al pavimento. Questa la posizione di partenza.\n" +
                "\n 2. Continua a mantenere una presa neutra durante l'intero esercizio. Solleva lentamente i manubri fino a quando le braccia non sono completamente distese.\n" +
                "\n 3. Mentre inspiri, abbassa i pesi fino a quando il tuo braccio è di nuovo a un angolo di 90 gradi.\n" +
                "\n 4. Ripeti per la quantità raccomandata di ripetizioni.\n" +
                "\n" +
                "Variante: questo esercizio può essere eseguito con un manubrio in un braccio e un altro appoggiato su una panca inclinata. Questo è un altro ottimo modo per aggiungere varietà alle tue routine e mantenerle interessanti.",R.drawable.shoulderdublepalms,"https://www.youtube.com/watch?v=6cZm9Hyx1GI"));
        RecyclerView recyclerView=findViewById(R.id.recyclerviewsp);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapterSpieg=new RecyclerViewAdapterSpieg(this,exscList);
        recyclerView.setAdapter(recyclerViewAdapterSpieg);

    }
}