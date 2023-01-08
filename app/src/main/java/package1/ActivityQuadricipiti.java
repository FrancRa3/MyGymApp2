package package1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import provaembrionale.Adapteres;
import ItemsClassi.Exsc;
import ui.RecyclerViewAdapterSpieg;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityQuadricipiti extends AppCompatActivity {

    private RecyclerViewAdapterSpieg recyclerViewAdapterSpieg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addome);
        List<Exsc> exscList=new ArrayList<Exsc>();
        View view=getLayoutInflater().inflate(R.layout.listesercizi,null);
        exscList.add(new Exsc("Squat: ","1. Questo esercizio viene eseguito al meglio all'interno di uno squat rack per motivi di sicurezza. Per iniziare, posiziona prima la barra su un rack appena sopra il livello delle spalle. Una volta scelta l'altezza corretta e caricata la barra, passa sotto la barra e posiziona la parte posteriore delle spalle (leggermente sotto il collo) sopra di essa.\n" +
                "\n 2. Afferra la barra usando entrambe le braccia ai lati e sollevala dal rack spingendo prima con le gambe e allo stesso tempo raddrizzando il busto.\n" +
                "\n 3. Allontanati dal rack e posiziona le gambe usando una posizione media alla larghezza delle spalle con le dita dei piedi leggermente appuntite. Tieni sempre la testa alta e mantieni la schiena dritta. Questa sarà la tua posizione iniziale.\n" +
                "\n 4. Inizia ad abbassare lentamente la barra piegando le ginocchia e sedendoti indietro con i fianchi mentre mantieni una postura eretta con la testa alta. Continua fino a quando i muscoli posteriori della coscia non sono sui polpacci. Inspira mentre esegui questa parte del movimento.\n" +
                "\n 5. Inizia ad alzare la barra mentre espiri spingendo il pavimento con il tallone o la metà del piede mentre raddrizzi le gambe ed estendi i fianchi per tornare alla posizione di partenza.\n" +
                "\n 6. Ripeti per la quantità consigliata di ripetizioni.\n" +
                "\n" +
                "Questo tipo di squat consente una maggiore libertà di movimento e consente al tronco di mantenere una posizione più verticale rispetto ad altri tipi di squat, grazie alla posizione dei piedi e alla posizione più alta della barra.",R.drawable.squat3,"https://www.youtube.com/watch?v=nan5BHL1kaY"));
        exscList.add(new Exsc("Affondi con Bilanciere: ","1.Inizia in piedi con i piedi alla larghezza delle spalle e un bilanciere sulla parte superiore della schiena.\n" +
                "\n 2. Fai un passo avanti con una gamba, flettendo le ginocchia per abbassare i fianchi. Scendi finché il ginocchio posteriore non tocca quasi il suolo. La tua postura dovrebbe rimanere eretta e il ginocchio anteriore dovrebbe rimanere sopra il piede anteriore.\n" +
                "\n 3. Attraversa il tallone del piede portante ed estendi entrambe le ginocchia per rialzarti.\n" +
                "\n 4. Fai un passo avanti con il piede posteriore, ripetendo l'affondo sulla gamba opposta.",R.drawable.affondi,"https://www.youtube.com/watch?v=-pj4BZhtVqs"));
        exscList.add(new Exsc("Single-Leg Press","1. Carica la slitta con un peso adeguato. Sedetevi sulla macchina, piantando un piede sulla piattaforma in linea con l'anca. Il tuo piede libero può essere appoggiato a terra. Mantieni una buona posizione della colonna vertebrale con la testa e il petto sollevati.\n" +
                "\n 2. Sostenendo il peso, estendi completamente il ginocchio e sblocca la slitta. Questa sarà la tua posizione iniziale.\n" +
                "\n 3. Abbassa il peso flettendo l'anca e il ginocchio, continuando fino a quando la flessibilità lo consente. Non permettere al tuo lombare di sostenere il carico muovendo il bacino.\n" +
                "\n 4. Alla fine del movimento fermati brevemente e poi torna alla posizione di partenza estendendo l'anca e il ginocchio.\n" +
                "\n 5. Completa tutte le ripetizioni per una gamba prima di passare all'altra.",R.drawable.singlelegpress,"https://www.youtube.com/watch?v=ZYDTJaAM-gE"));
        exscList.add(new Exsc("Tire Flip","1. Inizia afferrando la parte inferiore dello pneumatico sul battistrada e posiziona i piedi un po' indietro. Il tuo petto dovrebbe colpire la gomma.\n" +
                "\n 2. Per sollevare il pneumatico, estendi attraverso i fianchi, le ginocchia e le caviglie, guidando nel pneumatico e verso l'alto.\n" +
                "\n 3. Quando la gomma raggiunge un angolo di 45 gradi, fai un passo avanti e pianta un ginocchio nella gomma. Mentre lo fai, regola la presa sulla parte superiore del pneumatico e spingilo in avanti il \u200B\u200Bpiù forte possibile per completare la curva. Ripetere se necessario.\n" +
                "\n",R.drawable.tireflip,"https://www.youtube.com/watch?v=aIDjGG_xwHg"));
        RecyclerView recyclerView=findViewById(R.id.recyclerviewsp);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapterSpieg=new RecyclerViewAdapterSpieg(this,exscList);
        recyclerView.setAdapter(recyclerViewAdapterSpieg);
    }

}