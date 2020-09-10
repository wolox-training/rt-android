package ar.com.wolox.android.example.network.repository

import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.network.services.NewsService
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import javax.inject.Inject

class NewsRepository @Inject constructor(private val retrofitServices: RetrofitServices) {

    private val service: NewsService
        get() = retrofitServices.getService(NewsService::class.java)

    fun getNewsList() = service.getNews()

    fun getNewsHardcode(): List<News> = newsListHardcode

    fun getNewsToRefresh(): List<News> = newsToRefresh

    fun getSelectedNew(id: Int) = service.getSelectedNew(id)

    fun updateNew(id: Int, news: News) = service.updateNewSelected(id, news)

    private val newsListHardcode = listOf(
            News(
                    1,
                    2,
                    "2016-07-18T14:00:29.985Z",
                    "¿Famosos y sólo amigos?",
                    "http://bucket1.glanacion.com/anexos/fotos/70/dia-del-amigo-2236070w620.jpg",
                    "Ser súper estrellas e íntimos amigos tiene sus desventajas, al menos para George. Su esposa, Amal, es muy celosa de Julia e irrumpió varias veces en las grabaciones de su última peli juntos, aunque nunca pescó nada raro.",
                    listOf(1, 2)
            ),
            News(
                    2,
                    1,
                    "2016-07-18T14:01:38.673Z",
                    "Hipnosis: la nueva vedette de las neurociencias",
                    "http://bucket1.glanacion.com/anexos/fotos/50/2082050.jpg",
                    "Hace un año, Marisa Bello, bibliotecóloga de La Plata, separada, 51 años, condujo un auto ultralujoso. Luego, durmió profundamente. Más tarde, se rió a carcajadas y olió un perfume indescriptible. Todo eso lo vivió desde una silla, apostada en el escenario de un pabellón de Tecnópolis. Para ella, sucedió durante una hora. \"En realidad, estuvo entre dieciséis y dieciocho minutos, que es el tiempo máximo que utilizamos durante nuestros espectáculos para hipnotizar a la gente -explica Gonzalo Blanc, un abogado de 41 años-. Pero la percepción del tiempo en ese estado es otra, y eso la llevó a sentir la experiencia mucho más larga\". Durante dieciséis presentaciones en Tecnópolis, Gonzalo, junto con el médico Daniel West, de 30 años, practicaron hipnosis colectiva sobre el público. Los dos viven en Montevideo y se dedican desde hace más de diez años a investigar las neurociencias. Dan seminarios, conferencias y talleres empresariales para mejorar el rendimiento a través de la hipnosis -tuvieron clientes como YPF, Telefónica, L'Oréal y Santillana-; practican hipnosis clínica para atenuar el dolor y curar patologías, y sus conferencias en TEDx Durazno y en TEDx Río de la Plata, llamadas \"¿Se puede entrenar a la mente para ser exitosos?\", tienen más de 150.000 reproducciones. ",
                    listOf()
            ),
            News(
                    3,
                    2,
                    "2016-07-18T13:53:13.735Z",
                    "Como cuidar los muebles de cuero",
                    "http://bucket3.glanacion.com/anexos/fotos/28/soluciones-2231528w620.jpg",
                    "Generalmente los muebles de cuero son elegidos para destacarse porque resultan muy elegantes. Si bien el material es duradero, requiere de un mayor cuidado y mantenimiento que otros tipos de telas.",
                    listOf(3)
            ),
            News(
                    4,
                    2,
                    "2016-07-18T14:00:29.985Z",
                    "¿Famosos y sólo amigos?",
                    "http://bucket1.glanacion.com/anexos/fotos/70/dia-del-amigo-2236070w620.jpg",
                    "Ser súper estrellas e íntimos amigos tiene sus desventajas, al menos para George. Su esposa, Amal, es muy celosa de Julia e irrumpió varias veces en las grabaciones de su última peli juntos, aunque nunca pescó nada raro.",
                    listOf(1, 2)
            ),
            News(
                    5,
                    1,
                    "2016-07-18T14:01:38.673Z",
                    "Hipnosis: la nueva vedette de las neurociencias",
                    "http://bucket1.glanacion.com/anexos/fotos/50/2082050.jpg",
                    "Hace un año, Marisa Bello, bibliotecóloga de La Plata, separada, 51 años, condujo un auto ultralujoso. Luego, durmió profundamente. Más tarde, se rió a carcajadas y olió un perfume indescriptible. Todo eso lo vivió desde una silla, apostada en el escenario de un pabellón de Tecnópolis. Para ella, sucedió durante una hora. \"En realidad, estuvo entre dieciséis y dieciocho minutos, que es el tiempo máximo que utilizamos durante nuestros espectáculos para hipnotizar a la gente -explica Gonzalo Blanc, un abogado de 41 años-. Pero la percepción del tiempo en ese estado es otra, y eso la llevó a sentir la experiencia mucho más larga\". Durante dieciséis presentaciones en Tecnópolis, Gonzalo, junto con el médico Daniel West, de 30 años, practicaron hipnosis colectiva sobre el público. Los dos viven en Montevideo y se dedican desde hace más de diez años a investigar las neurociencias. Dan seminarios, conferencias y talleres empresariales para mejorar el rendimiento a través de la hipnosis -tuvieron clientes como YPF, Telefónica, L'Oréal y Santillana-; practican hipnosis clínica para atenuar el dolor y curar patologías, y sus conferencias en TEDx Durazno y en TEDx Río de la Plata, llamadas \"¿Se puede entrenar a la mente para ser exitosos?\", tienen más de 150.000 reproducciones. ",
                    listOf()
            ),
            News(
                    6,
                    2,
                    "2016-07-18T13:53:13.735Z",
                    "Como cuidar los muebles de cuero",
                    "http://bucket3.glanacion.com/anexos/fotos/28/soluciones-2231528w620.jpg",
                    "Generalmente los muebles de cuero son elegidos para destacarse porque resultan muy elegantes. Si bien el material es duradero, requiere de un mayor cuidado y mantenimiento que otros tipos de telas.",
                    listOf(3)
            ),
            News(
                    7,
                    2,
                    "2016-07-18T14:00:29.985Z",
                    "¿Famosos y sólo amigos?",
                    "http://bucket1.glanacion.com/anexos/fotos/70/dia-del-amigo-2236070w620.jpg",
                    "Ser súper estrellas e íntimos amigos tiene sus desventajas, al menos para George. Su esposa, Amal, es muy celosa de Julia e irrumpió varias veces en las grabaciones de su última peli juntos, aunque nunca pescó nada raro.",
                    listOf(1, 2)
            ),
            News(
                    8,
                    1,
                    "2016-07-18T14:01:38.673Z",
                    "Hipnosis: la nueva vedette de las neurociencias",
                    "http://bucket1.glanacion.com/anexos/fotos/50/2082050.jpg",
                    "Hace un año, Marisa Bello, bibliotecóloga de La Plata, separada, 51 años, condujo un auto ultralujoso. Luego, durmió profundamente. Más tarde, se rió a carcajadas y olió un perfume indescriptible. Todo eso lo vivió desde una silla, apostada en el escenario de un pabellón de Tecnópolis. Para ella, sucedió durante una hora. \"En realidad, estuvo entre dieciséis y dieciocho minutos, que es el tiempo máximo que utilizamos durante nuestros espectáculos para hipnotizar a la gente -explica Gonzalo Blanc, un abogado de 41 años-. Pero la percepción del tiempo en ese estado es otra, y eso la llevó a sentir la experiencia mucho más larga\". Durante dieciséis presentaciones en Tecnópolis, Gonzalo, junto con el médico Daniel West, de 30 años, practicaron hipnosis colectiva sobre el público. Los dos viven en Montevideo y se dedican desde hace más de diez años a investigar las neurociencias. Dan seminarios, conferencias y talleres empresariales para mejorar el rendimiento a través de la hipnosis -tuvieron clientes como YPF, Telefónica, L'Oréal y Santillana-; practican hipnosis clínica para atenuar el dolor y curar patologías, y sus conferencias en TEDx Durazno y en TEDx Río de la Plata, llamadas \"¿Se puede entrenar a la mente para ser exitosos?\", tienen más de 150.000 reproducciones. ",
                    listOf()
            ),
            News(
                    9,
                    2,
                    "2016-07-18T13:53:13.735Z",
                    "Como cuidar los muebles de cuero",
                    "http://bucket3.glanacion.com/anexos/fotos/28/soluciones-2231528w620.jpg",
                    "Generalmente los muebles de cuero son elegidos para destacarse porque resultan muy elegantes. Si bien el material es duradero, requiere de un mayor cuidado y mantenimiento que otros tipos de telas.",
                    listOf(3)
            ),
            News(
                    10,
                    2,
                    "2016-07-18T14:00:29.985Z",
                    "¿Famosos y sólo amigos?",
                    "http://bucket1.glanacion.com/anexos/fotos/70/dia-del-amigo-2236070w620.jpg",
                    "Ser súper estrellas e íntimos amigos tiene sus desventajas, al menos para George. Su esposa, Amal, es muy celosa de Julia e irrumpió varias veces en las grabaciones de su última peli juntos, aunque nunca pescó nada raro.",
                    listOf(1, 2)
            ),
            News(
                    11,
                    1,
                    "2016-07-18T14:01:38.673Z",
                    "Hipnosis: la nueva vedette de las neurociencias",
                    "http://bucket1.glanacion.com/anexos/fotos/50/2082050.jpg",
                    "Hace un año, Marisa Bello, bibliotecóloga de La Plata, separada, 51 años, condujo un auto ultralujoso. Luego, durmió profundamente. Más tarde, se rió a carcajadas y olió un perfume indescriptible. Todo eso lo vivió desde una silla, apostada en el escenario de un pabellón de Tecnópolis. Para ella, sucedió durante una hora. \"En realidad, estuvo entre dieciséis y dieciocho minutos, que es el tiempo máximo que utilizamos durante nuestros espectáculos para hipnotizar a la gente -explica Gonzalo Blanc, un abogado de 41 años-. Pero la percepción del tiempo en ese estado es otra, y eso la llevó a sentir la experiencia mucho más larga\". Durante dieciséis presentaciones en Tecnópolis, Gonzalo, junto con el médico Daniel West, de 30 años, practicaron hipnosis colectiva sobre el público. Los dos viven en Montevideo y se dedican desde hace más de diez años a investigar las neurociencias. Dan seminarios, conferencias y talleres empresariales para mejorar el rendimiento a través de la hipnosis -tuvieron clientes como YPF, Telefónica, L'Oréal y Santillana-; practican hipnosis clínica para atenuar el dolor y curar patologías, y sus conferencias en TEDx Durazno y en TEDx Río de la Plata, llamadas \"¿Se puede entrenar a la mente para ser exitosos?\", tienen más de 150.000 reproducciones. ",
                    listOf()
            ),
            News(
                    12,
                    2,
                    "2016-07-18T13:53:13.735Z",
                    "Como cuidar los muebles de cuero",
                    "http://bucket3.glanacion.com/anexos/fotos/28/soluciones-2231528w620.jpg",
                    "Generalmente los muebles de cuero son elegidos para destacarse porque resultan muy elegantes. Si bien el material es duradero, requiere de un mayor cuidado y mantenimiento que otros tipos de telas.",
                    listOf(3)
            )
    )

    private val newsToRefresh = listOf<News>(
        News(
            13,
            2,
            "2016-07-18T13:53:13.735Z",
            "Como cuidar los muebles de cuero",
            "",
            "Generalmente los muebles de cuero son elegidos para destacarse porque resultan muy elegantes. Si bien el material es duradero, requiere de un mayor cuidado y mantenimiento que otros tipos de telas.",
            listOf(3)
        ),
        News(
            14,
            2,
            "2016-07-18T13:53:13.735Z",
            "Como cuidar los muebles de cuero",
            "",
            "Generalmente los muebles de cuero son elegidos para destacarse porque resultan muy elegantes. Si bien el material es duradero, requiere de un mayor cuidado y mantenimiento que otros tipos de telas.",
            listOf(3)
        ),
        News(
            15,
            2,
            "2016-07-18T13:53:13.735Z",
            "Como cuidar los muebles de cuero",
            "",
            "Generalmente los muebles de cuero son elegidos para destacarse porque resultan muy elegantes. Si bien el material es duradero, requiere de un mayor cuidado y mantenimiento que otros tipos de telas.",
            listOf(3)
        ),
        News(
            16,
            2,
            "2016-07-18T13:53:13.735Z",
            "Como cuidar los muebles de cuero",
            "",
            "Generalmente los muebles de cuero son elegidos para destacarse porque resultan muy elegantes. Si bien el material es duradero, requiere de un mayor cuidado y mantenimiento que otros tipos de telas.",
            listOf(3)
        ),
        News(
            17,
            2,
            "2016-07-18T13:53:13.735Z",
            "Como cuidar los muebles de cuero",
            "",
            "Generalmente los muebles de cuero son elegidos para destacarse porque resultan muy elegantes. Si bien el material es duradero, requiere de un mayor cuidado y mantenimiento que otros tipos de telas.",
            listOf(3)
        ),
        News(
            18,
            2,
            "2016-07-18T13:53:13.735Z",
            "Como cuidar los muebles de cuero",
            "",
            "Generalmente los muebles de cuero son elegidos para destacarse porque resultan muy elegantes. Si bien el material es duradero, requiere de un mayor cuidado y mantenimiento que otros tipos de telas.",
            listOf(3)
        ),
        News(
            19,
            2,
            "2016-07-18T13:53:13.735Z",
            "Como cuidar los muebles de cuero",
            "",
            "Generalmente los muebles de cuero son elegidos para destacarse porque resultan muy elegantes. Si bien el material es duradero, requiere de un mayor cuidado y mantenimiento que otros tipos de telas.",
            listOf(3)
        ),
        News(
            20,
            2,
            "2016-07-18T13:53:13.735Z",
            "Como cuidar los muebles de cuero",
            "",
            "Generalmente los muebles de cuero son elegidos para destacarse porque resultan muy elegantes. Si bien el material es duradero, requiere de un mayor cuidado y mantenimiento que otros tipos de telas.",
            listOf(3)
        )
    )
}