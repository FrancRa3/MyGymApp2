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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ActivityAddome extends AppCompatActivity {

    private RecyclerViewAdapterSpieg recyclerViewAdapterSpieg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addome);
        List<Exsc> exscList=new ArrayList<Exsc>();
        View view=getLayoutInflater().inflate(R.layout.listesercizi,null);
        exscList.add(new Exsc("Plank","1. Mettiti in posizione prona sul pavimento, sostenendo il peso sulle dita dei piedi e sugli avambracci. Le tue braccia sono piegate e direttamente sotto la spalla.\n" +
                "2. Tieni il corpo sempre dritto e mantieni questa posizione il più a lungo possibile. Per aumentare la difficoltà, è possibile sollevare un braccio o una gamba."
                ,R.drawable.plank,"1"));
        exscList.add(new Exsc("Bottoms Up","1. Inizia sdraiandoti sulla schiena a terra. Le gambe dovrebbero essere dritte e le braccia lungo i fianchi. Questa sarà la tua posizione iniziale.\n" +
                "2. Per eseguire il movimento, piega le ginocchia verso il petto flettendo i fianchi e le ginocchia. Successivamente, estendi le gambe direttamente sopra di te in modo che siano perpendicolari al suolo. Ruota ed eleva il bacino per sollevare i glutei dal pavimento.\n" +
                "3. Dopo una breve pausa, torna alla posizione di partenza.",R.drawable.b1,"1"));
        exscList.add(new Exsc("Spider Crawl","1. Inizia in posizione prona sul pavimento. Sostieni il tuo peso sulle mani e sulle dita dei piedi, con i piedi uniti e il corpo dritto. Le tue braccia dovrebbero essere piegate a 90 gradi. Questa sarà la tua posizione iniziale.\n" +
                "\n 2. Inizia il movimento sollevando un piede da terra. Ruota esternamente la gamba e porta il ginocchio verso il gomito, il più avanti possibile.\n" +
                "\n 3. Riporta questa gamba nella posizione di partenza e ripeti sul lato opposto.\n" +
                "\n",R.drawable.spidercrawl,"https://www.youtube.com/watch?v=2Jczv6yuV_Y"));
        exscList.add(new Exsc("Dumbbell V-Sit Cross Jab","1. Inizia seduto sul sedere con le ginocchia piegate e i piedi a terra. Inclina la parte superiore del corpo all'indietro per formare un angolo di 45 gradi con il pavimento. Solleva i piedi da terra in modo che il tuo corpo assomigli a una forma a \"V\".\n" +
                "\n 2. Afferra un manubrio in ogni mano e tieniti stretto al petto con i palmi rivolti l'uno verso l'altro. Questa sarà la tua posizione iniziale.\n" +
                "\n 3. Mentre mantieni il tuo core stretto e mantieni la posizione a \"V\" del tuo corpo, estendi rapidamente il braccio sinistro verso l'esterno (simile a un jab) e poi riportalo alla posizione di partenza mentre contemporaneamente colpisci con il braccio destro.\n" +
                "\n 4. Il busto e le gambe possono ruotare leggermente da un lato all'altro di fronte alle mani durante il movimento: va bene.\n" +
                "\n 5. Un pugno con ciascuna mano conta come una ripetizione totale. Ripetere per il numero consigliato di ripetizioni.\n" +
                "\n",R.drawable.dumbeladd,"https://www.youtube.com/watch?v=VF7N6ZzrLWg"));
        exscList.add(new Exsc("Cocoons ","1. Inizia sdraiandoti sulla schiena a terra. Le gambe dovrebbero essere dritte e le braccia distese dietro la testa. Questa sarà la tua posizione iniziale.\n" +
                "\n 2. Per eseguire il movimento, piega le ginocchia verso il petto, ruotando il bacino per sollevare i glutei dal pavimento. Mentre lo fai, fletti la colonna vertebrale, riportando le braccia sopra la testa per eseguire un movimento di crunch simultaneo.\n" +
                "\n 3. Dopo una breve pausa, torna alla posizione di partenza.",R.drawable.cocoons,"https://www.youtube.com/watch?v=MWC2ZEs0I_g"));
        exscList.add(new Exsc("Cross-Body Crunch ","1. Sdraiati sulla schiena e piega le ginocchia di circa 60 gradi.\n" +
                "\n 2. Tieni i piedi appoggiati sul pavimento e metti le mani dietro la testa. Questa sarà la tua posizione iniziale.\n" +
                "\n 3. Ora rannicchiati e porta il gomito e la spalla destra sul corpo mentre contemporaneamente porta il ginocchio sinistro verso la spalla sinistra. Raggiungi il gomito e prova a toccare il ginocchio. Espira mentre esegui questo movimento. Suggerimento: cerca di portare la spalla verso il ginocchio piuttosto che solo il gomito e ricorda che la chiave è contrarre gli addominali mentre esegui il movimento; non solo per muovere il gomito.\n" +
                "\n 4. Ora torna alla posizione di partenza mentre inspiri e ripeti con il gomito sinistro e il ginocchio destro.\n" +
                "\n 5. Continua alternando in questo modo fino a quando tutte le ripetizioni prescritte sono state completate.\n" +
                "\n" +
                "Variazione: puoi anche eseguire tutte le tue ripetizioni per un lato e poi passare all'altro lato.\n" +
                "\n",R.drawable.elbowknee,"https://www.youtube.com/watch?v=aUV3UF9huYc"));
        exscList.add(new Exsc("Decline reverse crunch","1. Sdraiati sulla schiena su una panca declinata e aggrappati alla parte superiore della panca con entrambe le mani. Non lasciare che il tuo corpo scivoli giù da questa posizione.\n" +
                "\n 2. Tieni le gambe parallele al pavimento usando gli addominali per tenerle lì mentre tieni le ginocchia e i piedi uniti. Suggerimento: le gambe dovrebbero essere completamente distese con una leggera flessione del ginocchio. Questa sarà la tua posizione iniziale.\n" +
                "\n 3. Mentre espiri, muovi le gambe verso il busto mentre fai rotolare il bacino all'indietro e sollevi i fianchi dalla panca. Alla fine di questo movimento le tue ginocchia toccheranno il tuo petto.\n" +
                "\n 4. Mantieni la contrazione per un secondo e riporta le gambe nella posizione iniziale mentre inspiri.\n" +
                "\n 5. Ripeti per la quantità consigliata di ripetizioni.\n" +
                "\n" +
                "Variazioni: puoi eseguire il movimento su una superficie piana e, man mano che diventi più avanzato, puoi utilizzare i pesi per le caviglie.",R.drawable.declinecrunch,"https://www.youtube.com/watch?v=jYyA_6UR2lw"));
        RecyclerView recyclerView=findViewById(R.id.recyclerviewsp);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapterSpieg=new RecyclerViewAdapterSpieg(this,exscList);
        recyclerView.setAdapter(recyclerViewAdapterSpieg);
    }

}