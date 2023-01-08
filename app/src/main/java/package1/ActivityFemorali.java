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

public class ActivityFemorali extends AppCompatActivity {

    private RecyclerViewAdapterSpieg recyclerViewAdapterSpieg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addome);
        List<Exsc> exscList=new ArrayList<Exsc>();
        View view=getLayoutInflater().inflate(R.layout.listesercizi,null);
        exscList.add(new Exsc("STACCO DA TERRA","1.Avvicinati alla barra in modo che sia centrata sui tuoi piedi. I tuoi piedi dovrebbero essere divaricati all'incirca alla larghezza dei fianchi. Piegati all'anca per afferrare la barra alla larghezza delle spalle permettendo alle scapole di protrarsi. In genere, useresti una presa alternata.\n" +
                "\n 2. Con i piedi e la presa impostati, fai un respiro profondo e poi abbassa i fianchi e fletti le ginocchia finché gli stinchi non toccano la barra. Guarda avanti con la testa. Tieni il petto alto e la schiena inarcata e inizia a guidare attraverso i talloni per spostare il peso verso l'alto.\n" +
                "\n 3. Dopo che la barra ha superato le ginocchia, tirala indietro in modo aggressivo, unendo le scapole mentre spingi i fianchi in avanti nella barra.\n" +
                "\n 4. Abbassa la barra piegando i fianchi e guidandola verso il pavimento.",R.drawable.deadlift3,"https://www.youtube.com/watch?v=Upk0hRL3bUU"));
        exscList.add(new Exsc("STACCHI RUMENI CON MANUBRI","1.Inizia in posizione eretta con un manubrio in ogni mano. Assicurati che la schiena sia dritta e rimanga tale per tutta la durata dell'esercizio. Lascia che le braccia penzolino perpendicolarmente al pavimento, con i polsi pronati e i gomiti rivolti verso i fianchi. Questa sarà la tua posizione iniziale.\n" +
                "\n 2. Inizia il movimento flettendo i fianchi, spingendo lentamente il sedere il più indietro possibile. Ciò dovrebbe comportare un movimento orizzontale dei fianchi, piuttosto che un movimento verso il basso. Le ginocchia dovrebbero piegarsi solo parzialmente e il tuo peso dovrebbe rimanere sui talloni.\n" +
                "\n 3. Spingi indietro il sedere il più lontano possibile, il che dovrebbe generare tensione nei muscoli posteriori della coscia mentre le tue mani si avvicinano al livello del ginocchio. Mantenere un arco nella schiena durante l'esercizio.\n" +
                "\n 4. Quando i tuoi fianchi non possono eseguire ulteriori movimenti all'indietro, fai una pausa e poi torna lentamente alla posizione di partenza estendendo i fianchi.",R.drawable.stacchi3,"https://www.youtube.com/watch?v=RYK3IzXxFfY"));
        exscList.add(new Exsc("SQUAT: ","1. Questo esercizio viene eseguito al meglio all'interno di uno squat rack per motivi di sicurezza. Per iniziare, posiziona prima la barra su un rack appena sopra il livello delle spalle. Una volta scelta l'altezza corretta e caricata la barra, passa sotto la barra e posiziona la parte posteriore delle spalle (leggermente sotto il collo) sopra di essa.\n" +
                "\n 1. Afferra la barra usando entrambe le braccia ai lati e sollevala dal rack spingendo prima con le gambe e allo stesso tempo raddrizzando il busto.\n" +
                "\n 2. Allontanati dal rack e posiziona le gambe usando una posizione media alla larghezza delle spalle con le dita dei piedi leggermente appuntite. Tieni sempre la testa alta e mantieni la schiena dritta. Questa sarà la tua posizione iniziale.\n" +
                "\n 3. Inizia ad abbassare lentamente la barra piegando le ginocchia e sedendoti indietro con i fianchi mentre mantieni una postura eretta con la testa alta. Continua fino a quando i muscoli posteriori della coscia non sono sui polpacci. Inspira mentre esegui questa parte del movimento.\n" +
                "\n 4. Inizia ad alzare la barra mentre espiri spingendo il pavimento con il tallone o la metà del piede mentre raddrizzi le gambe ed estendi i fianchi per tornare alla posizione di partenza.\n" +
                "\n 5. Ripeti per la quantità consigliata di ripetizioni.\n" +
                "\n" +
                "Questo tipo di squat consente una maggiore libertà di movimento e consente al tronco di mantenere una posizione più verticale rispetto ad altri tipi di squat, grazie alla posizione dei piedi e alla posizione più alta della barra.",R.drawable.squat3,"https://www.youtube.com/watch?v=nan5BHL1kaY"));
        exscList.add(new Exsc("AFFONDI CON BILANCIERE: ","1.Inizia in piedi con i piedi alla larghezza delle spalle e un bilanciere sulla parte superiore della schiena.\n" +
                "\n 2. Fai un passo avanti con una gamba, flettendo le ginocchia per abbassare i fianchi. Scendi finché il ginocchio posteriore non tocca quasi il suolo. La tua postura dovrebbe rimanere eretta e il ginocchio anteriore dovrebbe rimanere sopra il piede anteriore.\n" +
                "\n 3. Attraversa il tallone del piede portante ed estendi entrambe le ginocchia per rialzarti.\n" +
                "\n 4. Fai un passo avanti con il piede posteriore, ripetendo l'affondo sulla gamba opposta.",R.drawable.affondi,"https://www.youtube.com/watch?v=-pj4BZhtVqs"));
        exscList.add(new Exsc("Barbell Hip Thrust","1. Inizia seduto a terra con una panca direttamente dietro di te. Tieni un bilanciere carico sopra le gambe. Usare una barra di grasso o avere un cuscinetto sulla barra può ridurre notevolmente il disagio causato da questo esercizio.\n" +
                "\n 2. Ruota la barra in modo che sia direttamente sopra i fianchi e appoggiati alla panca in modo che le scapole siano vicine alla parte superiore.\n" +
                "\n 3. Inizia il movimento spingendo attraverso i piedi, estendendo i fianchi verticalmente attraverso la barra. Il tuo peso dovrebbe essere sostenuto dalle scapole e dai piedi. Estendi il più possibile, quindi inverti il \u200B\u200Bmovimento per tornare alla posizione iniziale.",R.drawable.hiptrust,"https://www.youtube.com/watch?v=IHk9Qn8ttX8"));
        exscList.add(new Exsc("Single-leg cable hip extension","1. Aggancia un polsino alla caviglia in pelle a una puleggia bassa e poi attacca il polsino alla caviglia.\n" +
                "\n 2. Affronta il pacco pesi da una distanza di circa due piedi, afferrando il telaio in acciaio per il supporto.\n" +
                "\n 3. Mantenendo le ginocchia e i fianchi leggermente piegati e gli addominali tesi, contrai i glutei per \"calciare\" lentamente la gamba che lavora indietro in un arco semicircolare il più in alto possibile mentre espiri. Suggerimento: alla massima estensione, contrai i glutei per un secondo per ottenere una contrazione massima.\n" +
                "\n 4. Ora porta lentamente in avanti la gamba che lavora, resistendo alla trazione del cavo fino a raggiungere la posizione di partenza.\n" +
                "\n 5. Ripeti per la quantità consigliata di ripetizioni.\n" +
                "\n 6. Cambia gamba e ripeti il movimento per l'altro lato.\n" +
                "\n" +
                "Variazioni: puoi eseguire questo esercizio con le fasce elastiche.",R.drawable.cablehip,"https://www.youtube.com/watch?v=dJa_Nf4zdik"));
        RecyclerView recyclerView=findViewById(R.id.recyclerviewsp);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapterSpieg=new RecyclerViewAdapterSpieg(this,exscList);
        recyclerView.setAdapter(recyclerViewAdapterSpieg);
    }
}