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

public class ActivityPolpacci extends AppCompatActivity {

    private RecyclerViewAdapterSpieg recyclerViewAdapterSpieg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addome);
        List<Exsc> exscList=new ArrayList<Exsc>();
        View view=getLayoutInflater().inflate(R.layout.listesercizi,null);
        exscList.add(new Exsc("Standing Calf Raises","1. Regola la leva imbottita della macchina per il sollevamento del polpaccio per adattarla alla tua altezza.\n" +
                "\n 2. Posizionare le spalle sotto i cuscinetti forniti e posizionare le punte dei piedi rivolte in avanti (o utilizzando una delle altre due posizioni descritte all'inizio del capitolo). Gli avampiedi dovrebbero essere fissati sopra il blocco del polpaccio con i talloni che si estendono da esso. Spingi la leva verso l'alto estendendo i fianchi e le ginocchia finché il busto non è eretto. Le ginocchia dovrebbero essere mantenute leggermente piegate; mai chiuso. Le dita dei piedi dovrebbero essere rivolte in avanti, verso l'esterno o verso l'interno come descritto all'inizio del capitolo. Questa sarà la tua posizione iniziale.\n" +
                "\n 3. Alza i talloni mentre espiri estendendo le caviglie il più in alto possibile e flettendo il polpaccio. Assicurarsi che il ginocchio sia sempre fermo. Non ci dovrebbero essere flessioni in nessun momento. Mantieni la posizione contratta per un secondo prima di iniziare a scendere.\n" +
                "\n 4. Torna lentamente alla posizione di partenza mentre inspiri abbassando i talloni mentre pieghi le caviglie finché i polpacci non sono tesi.\n" +
                "\n 5. Ripeti per la quantità consigliata di ripetizioni.\n" +
                "\n" +
                "Attenzione: se si soffre di problemi alla parte bassa della schiena, un esercizio migliore è il calf press poiché durante un sollevamento del polpaccio in piedi la schiena deve sostenere il peso che viene sollevato. Inoltre, mantieni la schiena dritta e ferma in ogni momento. L'arrotondamento della schiena può causare lesioni lombari.\n" +
                "\n" +
                "Variazioni: ci sono molti altri modi per eseguire un sollevamento del polpaccio in piedi. Un bilanciere invece di una macchina può essere utilizzato invece così come manubri, una gamba o due gambe alla volta. Fare riferimento alle descrizioni degli esercizi di questi movimenti di seguito. Una macchina da fabbro può essere utilizzata anche per il sollevamento dei polpacci.",R.drawable.polpacciraise,"https://www.youtube.com/watch?v=SorIB5_zO9A"));
        exscList.add(new Exsc("Seated Calf Raise ","1. Sedersi sulla macchina e posizionare le dita dei piedi sulla parte inferiore della piattaforma fornita con i talloni che si estendono. Scegli il posizionamento della punta che preferisci (in avanti, dentro o fuori) come indicato all'inizio di questo capitolo.\n" +
                "\n 2. Posiziona la parte inferiore delle cosce sotto il lever pad, che dovrà essere regolato in base all'altezza delle tue cosce. Ora posiziona le mani sulla parte superiore del lever pad per evitare che scivoli in avanti.\n" +
                "\n 3. Sollevare leggermente la leva spingendo i talloni verso l'alto e rilasciare la barra di sicurezza. Questa sarà la tua posizione iniziale.\n" +
                "\n 4. Abbassa lentamente i talloni piegando le caviglie finché i polpacci non sono completamente tesi. Inspira mentre esegui questo movimento.\n" +
                "\n 5. Solleva i talloni estendendo le caviglie il più in alto possibile mentre contrai i polpacci ed espiri. Mantieni la contrazione superiore per un secondo.\n" +
                "    Ripeti per la quantità consigliata di ripetizioni.\n" +
                "\n",R.drawable.seatedcalf,"https://www.youtube.com/watch?v=SjJka466dfY"));
        exscList.add(new Exsc("Calf Press On The Leg Press Machine","1. Usando una pressa per gambe, siediti sulla macchina e posiziona le gambe sulla piattaforma direttamente di fronte a te in una posizione del piede media (larghezza delle spalle).\n" +
                "\n 2. Abbassa le barre di sicurezza che tengono in posizione la piattaforma ponderata e premi la piattaforma fino in fondo finché le gambe non sono completamente distese davanti a te senza bloccare le ginocchia. (Nota: in alcune unità leg press puoi lasciare le barre di sicurezza per una maggiore sicurezza. Se la tua unità leg press lo consente, allora questo è il metodo preferito per eseguire l'esercizio.) Il tuo busto e le gambe dovrebbero essere perfetti a 90- angolo di grado. Ora posiziona con cura le dita dei piedi e gli avampiedi sulla parte inferiore della piattaforma con i talloni che si estendono. Le dita dei piedi dovrebbero essere rivolte in avanti, verso l'esterno o verso l'interno come descritto all'inizio del capitolo. Questa sarà la tua posizione iniziale.\n" +
                "\n 3. Premi sulla piattaforma sollevando i talloni mentre espiri estendendo le caviglie il più in alto possibile e flettendo il polpaccio. Assicurarsi che il ginocchio sia sempre fermo. Non ci dovrebbero essere flessioni in nessun momento. Mantieni la posizione contratta per un secondo prima di iniziare a scendere.\n" +
                "\n 4. Torna lentamente alla posizione di partenza mentre inspiri abbassando i talloni mentre pieghi le caviglie finché i polpacci non sono tesi.\n" +
                "\n 5. Ripeti per la quantità consigliata di ripetizioni.\n" +
                "\n" +
                "\n Attenzione: prestare molta attenzione quando si posizionano i piedi nella parte inferiore della piattaforma poiché se si scivola e le barre di sicurezza non sono bloccate, si potrebbe subire un grave incidente.",R.drawable.calfpressa,"https://www.youtube.com/watch?v=M4FojyRAcuE"));
        exscList.add(new Exsc("Weighted donkey calf raise","1. Per questo esercizio avrai bisogno di una macchina per allevare vitelli d'asino. Inizia posizionando la parte bassa della schiena e i fianchi sotto la leva imbottita fornita. L'area del coccige dovrebbe essere quella che entra in contatto con il cuscinetto.\n" +
                "\n 2. Posiziona entrambe le braccia sulle maniglie laterali e posiziona le punte dei piedi sul blocco del polpaccio con i talloni che si estendono. Allinea le dita dei piedi in avanti, verso l'interno o verso l'esterno, a seconda dell'area che desideri colpire, e raddrizza le ginocchia senza bloccarle. Questa sarà la tua posizione iniziale.\n" +
                "\n 3. Alza i talloni mentre espiri estendendo le caviglie il più in alto possibile e flettendo il polpaccio. Assicurarsi che il ginocchio sia sempre fermo. Non ci dovrebbero essere flessioni in nessun momento. Mantieni la posizione contratta per un secondo prima di iniziare a scendere.\n" +
                "\n 4. Torna lentamente alla posizione di partenza mentre inspiri abbassando i talloni mentre pieghi le caviglie finché i polpacci non sono tesi.\n" +
                "\n 5. Ripeti per la quantità consigliata di ripetizioni.\n" +
                "\n" +
                "\n Varianti: se non hai a disposizione una macchina ma hai accesso a un blocco per i polpacci e un oggetto robusto a cui aggrapparti, puoi eseguire questa operazione usando come resistenza una persona seduta sulla parte bassa della schiena (intorno all'area del coccige).\n" +
                "\n",R.drawable.donkeycalf,"https://www.youtube.com/watch?v=yEAi8wec5ZM"));
        RecyclerView recyclerView=findViewById(R.id.recyclerviewsp);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapterSpieg=new RecyclerViewAdapterSpieg(this,exscList);
        recyclerView.setAdapter(recyclerViewAdapterSpieg);
    }

}