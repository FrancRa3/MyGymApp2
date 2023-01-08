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

public class ActivityBicipiti extends AppCompatActivity {

    private RecyclerViewAdapterSpieg recyclerViewAdapterSpieg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addome);
        List<Exsc> exscList=new ArrayList<Exsc>();
        View view=getLayoutInflater().inflate(R.layout.listesercizi,null); //Aggiungo esercizi

        exscList.add(new Exsc("Hammer Curl","1. Alzati in piedi con il busto eretto e un manubrio su ogni mano tenuto alla lunghezza delle braccia. I gomiti dovrebbero essere vicini al busto.\n" +
                "\n 2. I palmi delle mani dovrebbero essere rivolti verso il busto. Questa sarà la tua posizione iniziale.\n" +
                "\n 3. Ora, tenendo ferma la parte superiore del braccio, espira e piega il peso in avanti mentre contrai i bicipiti. Continua a sollevare il peso finché i bicipiti non sono completamente contratti e il manubrio è all'altezza delle spalle. Mantieni la posizione contratta per un breve momento mentre stringi i bicipiti. Suggerimento: concentrati sul mantenere fermo il gomito e muovere solo l'avambraccio.\n" +
                "\n 4. Dopo la breve pausa, inspira e inizia lentamente ad abbassare i manubri nella posizione di partenza.\n" +
                "\n 5. Ripeti per la quantità raccomandata di ripetizioni.\n" +
                "\n",R.drawable.hammer,"https://www.youtube.com/watch?v=TwD-YGVP4Bk"));
        exscList.add(new Exsc("EZ-BAR Curl: ","1. Stai dritto mentre tieni una barra per curl EZ sull'ampia maniglia esterna. I palmi delle mani dovrebbero essere rivolti in avanti e leggermente inclinati verso l'interno a causa della forma della barra. Tieni i gomiti vicini al busto. Questa sarà la tua posizione iniziale.\n" +
                "\n 2. Ora, mantenendo ferma la parte superiore delle braccia, espira e arriccia i pesi in avanti mentre contrai i bicipiti. Concentrati solo sul movimento degli avambracci.\n" +
                "\n 3. Continua a sollevare il peso fino a quando i bicipiti non sono completamente contratti e la barra è all'altezza delle spalle. Mantieni la posizione contratta in alto per un momento e stringi i bicipiti.\n" +
                "\n 4. Quindi inspira e abbassa lentamente la barra nella posizione iniziale.\n" +
                "\n 5. Ripeti per la quantità raccomandata di ripetizioni.",R.drawable.ezbar,"https://www.youtube.com/watch?v=kwG2ipFRgfo"));
        exscList.add(new Exsc("Curl di Concentrazione","1. Siediti su una panca piana con un manubrio davanti a te tra le gambe. Le gambe dovrebbero essere divaricate con le ginocchia piegate e i piedi sul pavimento.\n" +
                "\n 2. Usa il braccio destro per sollevare il manubrio. Posiziona la parte posteriore della parte superiore del braccio destro sulla parte superiore della parte interna della coscia destra. Ruota il palmo della mano finché non è rivolto in avanti rispetto alla coscia. Suggerimento: il braccio dovrebbe essere esteso e il manubrio dovrebbe essere sopra il pavimento. Questa sarà la tua posizione iniziale.\n" +
                "\n 3. Tenendo ferma la parte superiore del braccio, arriccia i pesi in avanti mentre contrai i bicipiti mentre espiri. Dovrebbero muoversi solo gli avambracci. Continua il movimento finché i bicipiti non sono completamente contratti e i manubri sono all'altezza delle spalle. Suggerimento: nella parte superiore del movimento assicurati che il mignolo del braccio sia più in alto del pollice. Questo garantisce una buona contrazione. Mantieni la posizione contratta per un secondo mentre stringi i bicipiti.\n" +
                "\n 4. Inizia lentamente a riportare i manubri nella posizione iniziale mentre inspiri. Attenzione: evita movimenti oscillanti in qualsiasi momento.\n" +
                "\n 5. Ripeti per la quantità raccomandata di ripetizioni. Quindi ripetere il movimento con il braccio sinistro.",R.drawable.concurl,"https://www.youtube.com/watch?v=0AUGkch3tzc"));
        exscList.add(new Exsc("Curl con Manubri","1. Stai dritto con un manubrio in ogni mano a distanza di un braccio. Tieni i gomiti vicini al busto e ruota i palmi delle mani finché non sono rivolti in avanti. Questa sarà la tua posizione iniziale.\n" +
                "\n 2. Ora, mantenendo ferma la parte superiore delle braccia, espira e arriccia i pesi mentre contrai i bicipiti. Continua a sollevare i pesi finché i bicipiti non sono completamente contratti e i manubri sono all'altezza delle spalle. Mantieni la posizione contratta per una breve pausa mentre stringi i bicipiti.\n" +
                "\n 3. Quindi, inspira e inizia lentamente ad abbassare i manubri nella posizione iniziale.\n" +
                "\n 4. Ripeti per la quantità raccomandata di ripetizioni.",R.drawable.cb,"https://www.youtube.com/watch?v=1Qp04kK-k6U"));
        exscList.add(new Exsc("Wide-grip barbell curl","1. Alzati con il busto eretto mentre tieni un bilanciere sull'ampia maniglia esterna. Il palmo delle mani dovrebbe essere rivolto in avanti. I gomiti dovrebbero essere vicini al busto. Questa sarà la tua posizione iniziale.\n" +
                "\n 2. Tenendo ferma la parte superiore delle braccia, arriccia i pesi in avanti mentre contrai i bicipiti mentre espiri. Suggerimento: dovrebbero muoversi solo gli avambracci.\n" +
                "\n 3. Continua il movimento finché i bicipiti non sono completamente contratti e la barra è all'altezza delle spalle. Mantieni la posizione contratta per un secondo e stringi forte i bicipiti.\n" +
                "\n 4. Inizia lentamente a riportare la barra nella posizione iniziale mentre inspiri.\n" +
                "\n 5. Ripeti per la quantità consigliata di ripetizioni.\n" +
                "\n" +
                "Variazioni:\n" +
                "\n" +
                "    Puoi anche eseguire questo movimento utilizzando una barra E-Z o un attacco E-Z agganciato a una carrucola bassa. Questa variazione sembra davvero fornire una buona contrazione nella parte superiore del movimento.\n" +
                "    Puoi anche usare la presa più stretta per scopi vari.\n" +
                "\n",R.drawable.curlbarra,"https://www.youtube.com/watch?v=JJB8XgKltA8"));
        RecyclerView recyclerView=findViewById(R.id.recyclerviewsp);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapterSpieg=new RecyclerViewAdapterSpieg(this,exscList);
        recyclerView.setAdapter(recyclerViewAdapterSpieg);
    }

}