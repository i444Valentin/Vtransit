<H2>Здесь будут технические моменты, касаемо разработки приложения</H2>

<H3>Архитектура</H3>
Планируется разбить приложение на два модуля:
Серверная часть, взяимодействующая с базой данных:
<br>
<b>backend-database</b>
<br>
Клиентская часть, работающая с интерфейсом web-приложения (по-сути это тоже серверная):
<br>
<b>backend-frontend</b>

Передача данных между модулями будет реализована с помощью Kafka.<br>
Схематично это будет выглядеть так:

<table>
    <tr height="100">
        <td>
            backend-database
        </td>
        <td>
            ----><br><----
        </td>
        <td>
            Apache Kafka
        </td>
        <td>
            ----><br><----
        </td>
        <td>
            backend-frontend
        </td>
    </tr>
</table>

Модуль <i>backend-database</i> принимает данные из кафки и записывает их в базу. Также
модуль пишет в кафку данные по запросу от модуля backend-frontend из кафки.

Модуль <i>backend-frontend</i> отвечает за веб-интерфейс. Данные, полученные от
пользователя он пишет в кафку, и наоборот, берет оттуда для вывода пользователю.

Пока на данном этапе все.

