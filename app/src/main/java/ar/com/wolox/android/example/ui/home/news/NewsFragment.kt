package ar.com.wolox.android.example.ui.home.news

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_news.*
import javax.inject.Inject

class NewsFragment @Inject constructor() : WolmoFragment<NewsPresenter>(), NewsView {

    private val newsList = listOf(
        News(
            1,
            2,
            "2016-07-18T14:00:29.985Z",
            "¿Famosos y sólo amigos?",
            "http://bucket1.glanacion.com/anexos/fotos/70/dia-del-amigo-2236070w620.jpg",
            "Ser súper estrellas e íntimos amigos tiene sus desventajas, al menos para George. Su esposa, Amal, es muy celosa de Julia e irrumpió varias veces en las grabaciones de su última peli juntos, aunque nunca pescó nada raro.",
            intArrayOf(1, 2)
        ),
        News(
            2,
            1,
            "2016-07-18T14:01:38.673Z",
            "Hipnosis: la nueva vedette de las neurociencias",
            "http://bucket1.glanacion.com/anexos/fotos/50/2082050.jpg",
            "Hace un año, Marisa Bello, bibliotecóloga de La Plata, separada, 51 años, condujo un auto ultralujoso. Luego, durmió profundamente. Más tarde, se rió a carcajadas y olió un perfume indescriptible. Todo eso lo vivió desde una silla, apostada en el escenario de un pabellón de Tecnópolis. Para ella, sucedió durante una hora. \"En realidad, estuvo entre dieciséis y dieciocho minutos, que es el tiempo máximo que utilizamos durante nuestros espectáculos para hipnotizar a la gente -explica Gonzalo Blanc, un abogado de 41 años-. Pero la percepción del tiempo en ese estado es otra, y eso la llevó a sentir la experiencia mucho más larga\". Durante dieciséis presentaciones en Tecnópolis, Gonzalo, junto con el médico Daniel West, de 30 años, practicaron hipnosis colectiva sobre el público. Los dos viven en Montevideo y se dedican desde hace más de diez años a investigar las neurociencias. Dan seminarios, conferencias y talleres empresariales para mejorar el rendimiento a través de la hipnosis -tuvieron clientes como YPF, Telefónica, L'Oréal y Santillana-; practican hipnosis clínica para atenuar el dolor y curar patologías, y sus conferencias en TEDx Durazno y en TEDx Río de la Plata, llamadas \"¿Se puede entrenar a la mente para ser exitosos?\", tienen más de 150.000 reproducciones. ",
            intArrayOf()
        ),
        News(
            3,
            2,
            "2016-07-18T13:53:13.735Z",
            "Como cuidar los muebles de cuero",
            "http://bucket3.glanacion.com/anexos/fotos/28/soluciones-2231528w620.jpg",
            "Generalmente los muebles de cuero son elegidos para destacarse porque resultan muy elegantes. Si bien el material es duradero, requiere de un mayor cuidado y mantenimiento que otros tipos de telas.",
            intArrayOf(3)
        ),
        News(
            4,
            2,
            "2016-07-18T14:00:29.985Z",
            "¿Famosos y sólo amigos?",
            "http://bucket1.glanacion.com/anexos/fotos/70/dia-del-amigo-2236070w620.jpg",
            "Ser súper estrellas e íntimos amigos tiene sus desventajas, al menos para George. Su esposa, Amal, es muy celosa de Julia e irrumpió varias veces en las grabaciones de su última peli juntos, aunque nunca pescó nada raro.",
            intArrayOf(1, 2)
        ),
        News(
            5,
            1,
            "2016-07-18T14:01:38.673Z",
            "Hipnosis: la nueva vedette de las neurociencias",
            "http://bucket1.glanacion.com/anexos/fotos/50/2082050.jpg",
            "Hace un año, Marisa Bello, bibliotecóloga de La Plata, separada, 51 años, condujo un auto ultralujoso. Luego, durmió profundamente. Más tarde, se rió a carcajadas y olió un perfume indescriptible. Todo eso lo vivió desde una silla, apostada en el escenario de un pabellón de Tecnópolis. Para ella, sucedió durante una hora. \"En realidad, estuvo entre dieciséis y dieciocho minutos, que es el tiempo máximo que utilizamos durante nuestros espectáculos para hipnotizar a la gente -explica Gonzalo Blanc, un abogado de 41 años-. Pero la percepción del tiempo en ese estado es otra, y eso la llevó a sentir la experiencia mucho más larga\". Durante dieciséis presentaciones en Tecnópolis, Gonzalo, junto con el médico Daniel West, de 30 años, practicaron hipnosis colectiva sobre el público. Los dos viven en Montevideo y se dedican desde hace más de diez años a investigar las neurociencias. Dan seminarios, conferencias y talleres empresariales para mejorar el rendimiento a través de la hipnosis -tuvieron clientes como YPF, Telefónica, L'Oréal y Santillana-; practican hipnosis clínica para atenuar el dolor y curar patologías, y sus conferencias en TEDx Durazno y en TEDx Río de la Plata, llamadas \"¿Se puede entrenar a la mente para ser exitosos?\", tienen más de 150.000 reproducciones. ",
            intArrayOf()
        ),
        News(
            6,
            2,
            "2016-07-18T13:53:13.735Z",
            "Como cuidar los muebles de cuero",
            "http://bucket3.glanacion.com/anexos/fotos/28/soluciones-2231528w620.jpg",
            "Generalmente los muebles de cuero son elegidos para destacarse porque resultan muy elegantes. Si bien el material es duradero, requiere de un mayor cuidado y mantenimiento que otros tipos de telas.",
            intArrayOf(3)
        ),
        News(
            7,
            2,
            "2016-07-18T14:00:29.985Z",
            "¿Famosos y sólo amigos?",
            "http://bucket1.glanacion.com/anexos/fotos/70/dia-del-amigo-2236070w620.jpg",
            "Ser súper estrellas e íntimos amigos tiene sus desventajas, al menos para George. Su esposa, Amal, es muy celosa de Julia e irrumpió varias veces en las grabaciones de su última peli juntos, aunque nunca pescó nada raro.",
            intArrayOf(1, 2)
        ),
        News(
            8,
            1,
            "2016-07-18T14:01:38.673Z",
            "Hipnosis: la nueva vedette de las neurociencias",
            "http://bucket1.glanacion.com/anexos/fotos/50/2082050.jpg",
            "Hace un año, Marisa Bello, bibliotecóloga de La Plata, separada, 51 años, condujo un auto ultralujoso. Luego, durmió profundamente. Más tarde, se rió a carcajadas y olió un perfume indescriptible. Todo eso lo vivió desde una silla, apostada en el escenario de un pabellón de Tecnópolis. Para ella, sucedió durante una hora. \"En realidad, estuvo entre dieciséis y dieciocho minutos, que es el tiempo máximo que utilizamos durante nuestros espectáculos para hipnotizar a la gente -explica Gonzalo Blanc, un abogado de 41 años-. Pero la percepción del tiempo en ese estado es otra, y eso la llevó a sentir la experiencia mucho más larga\". Durante dieciséis presentaciones en Tecnópolis, Gonzalo, junto con el médico Daniel West, de 30 años, practicaron hipnosis colectiva sobre el público. Los dos viven en Montevideo y se dedican desde hace más de diez años a investigar las neurociencias. Dan seminarios, conferencias y talleres empresariales para mejorar el rendimiento a través de la hipnosis -tuvieron clientes como YPF, Telefónica, L'Oréal y Santillana-; practican hipnosis clínica para atenuar el dolor y curar patologías, y sus conferencias en TEDx Durazno y en TEDx Río de la Plata, llamadas \"¿Se puede entrenar a la mente para ser exitosos?\", tienen más de 150.000 reproducciones. ",
            intArrayOf()
        ),
        News(
            9,
            2,
            "2016-07-18T13:53:13.735Z",
            "Como cuidar los muebles de cuero",
            "http://bucket3.glanacion.com/anexos/fotos/28/soluciones-2231528w620.jpg",
            "Generalmente los muebles de cuero son elegidos para destacarse porque resultan muy elegantes. Si bien el material es duradero, requiere de un mayor cuidado y mantenimiento que otros tipos de telas.",
            intArrayOf(3)
        )
    )

    override fun layout(): Int = R.layout.fragment_news

    override fun init() {
        vNewsSwipeRefreshLayout.setOnRefreshListener {
            vNewsSwipeRefreshLayout.isRefreshing = false
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (newsList.isEmpty()) {
            Toast.makeText(requireContext(), "Don't exists news to show.", Toast.LENGTH_SHORT).show()
        } else {
            super.onViewCreated(view, savedInstanceState)
            vNewsRecyclerView.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = NewsAdapter(newsList)
            }
        }
    }

    companion object {
        fun newInstance() = NewsFragment()
    }
}