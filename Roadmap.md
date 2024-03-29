## План выполнения проекта:

1 - Создайте основную модель Vehicle (автомобиль), поля на ваше усмотрение
(стоимость, год выпуска, пробег, и т - д.), но саму марку/бренд с техническими характеристиками пока не добавляйте, это будет отдельная модель.

Сделайте максимально простой веб-интерфейс, чтобы можно было просто просмотреть список машин в базе (без редактирования) - Присылаете скриншот веб-интерфейса со списком машинок (2-3 штуки).

2 - Добавьте отдельную модель брендов (имя бренда, тип (легковой, грузовой, автобус, ...), 3-4 другие хар-ки - бак, грузоподъёмность, кол-во мест), и привяжите её к модели машинки.

Чтобы в UI также список брендов отдельно можно было просмотреть, как и список машинок.

3 - Теперь добавьте в UI максимально простой CRUD - редактирование добавление удаление автомобилей.

4 - Добавьте REST API, по которому (по отдельному url) будет выдаваться список всех машинок в формате json.

6 - Добавьте ещё две базовые модели:
Enterprise (предприятие)
Driver (водитель)

Основные поля этим моделям придумайте сами - Например, название + город, имя + зарплата.

Организуйте между ними такие связи:
Предприятию могут принадлежать несколько автомобилей (один ко многим).
Предприятию могут принадлежать несколько водителей (один ко многим).

Автомобиль и водитель могут принадлежать только одному предприятию.
Каждому автомобилю может быть назначено несколько водителей (один к многим).
Один из назначенных водителей дополнительно считается "активным" (флажок) — это тот, кто работает на машине в данный момент.
Создаваемый водитель исходно ни к какой машине не привязан.

Списки водителей и предприятий отдельно выдавайте через REST.

7 - Добавьте модель Manager (менеджер), наследник от User
(менеджер авторизовывается как обычный user — добавьте авторизацию логин-пароль).
Менеджеру могут "принадлежать" (быть видимыми) несколько предприятий.
Менеджер получает в REST-запросах только объекты видимых ему предприятий.

Сделайте случай, когда три предприятия 1,2,3 и два менеджера, одному принадлежат предприятия 1,2, другому 2,3.

8 - Изучите, что такое curl, и организуйте с его помощью запрос машинок с авторизацией менеджера, как вы это в браузере делали - 

9 - Проверьте, защита от CSRF в спринге включена?
Если нет, включите и проверьте как работает с ней
по-моему ```csrf().enable()```

10 - Сделайте REST-добавление новой/изменение полей существующей заданной машинки, и её удаление
— через PUT/POST/DELETE, после того как менеджер авторизовался - Проверьте из curl.

11 - Напишите утилиту генерации для предприятия (списка предприятий) заданного количества машинок, содержимое их формируйте случайно, и водителей (чтобы примерно каждая 10-я машинка была с активным водителем).

12 - Сгенерируйте для 3 предприятий по 5-10 тысяч машин, и разберитесь, как через REST API получать их в режиме пагинации — не все разом, а листать страничками по 20-50 машинок.

13 - Начните разбираться с бутстрапом (его сам по себе полезно знать) - Сделайте простую форму ввода логина-пароля, менеджер заходит через неё и видит список всех своих видимых предприятий (и пока больше ничего).

Проверьте, как UI будет работать на мобильных устройствах.

14 - Теперь добавьте несложный интерфейс для менеджера — добавление/редактирование/удаление машинок в выбранном предприятии.

15 - Добавьте предприятию локальную таймзону (таймзона также может быть не задана, тогда считается UTC) - Сделайте для машинок какое-нибудь поле, связанное с датой-временем (например, дата и время покупки), которое в машине (на сервере) всегда хранится как UTC - Выводите его в запросах API и в UI с учётом таймзоны предприятия, и с учётом, что у клиента в браузере скорее всего своя локальная таймзона (показать надо соответственно в его таймзоне).

16 - Дальше, будет экспериментальное задание, постарайтесь придумать сами, как лучше сделать.
Нам надо хранить трек — набор точек GPS, условную поездку автомобиля с привязкой к нему.
По-моему, в Spring есть GeoPoint - Можно каждую точку дополнять id автомобиля, и складывать это всё в кучу в одну табличку, но в целом она получится огромной, и работать будет медленно.
То есть, как оптимальнее хранить трек, в котором может быть много (потенциально неограниченное) количество gps-точек, посмотрите GPS tracking в Java например - Но слишком не заморачивайтесь, в одной табличке тоже в принципе нормально все точки держать.

17 - Дальше, добавьте в REST API выдачу точек трека по заданному автомобилю и диапазону дат/времени с учётом локальной таймзоны предприятия (сами точки на сервере хранят дату время в UTC).

18 - Добавьте модель Поездка, в которой хранится автомобиль, и дата-время в UTC начало и окончание поездки без ограничений (может быть два часа, может быть два года).
В API сделайте запрос, который по заданным дате-времени начала и конца вытащит все поездки (считаем, что они в таймзоне предприятия) — запрос именно по поездкам, но выдаются только точки трека по id заданного автомобиля (точки могут быть из нескольких треков; условно, я могу запросить за месяц все поездки, и получу один огромный трек).
Если начало первой поездки раньше начального времени запроса, или окончание последней поездки позже времени конца запроса, то их не включаем в выдачу.

19 - Теперь выдавайте сами поездки: добавьте REST-запрос, который по заданному диапазону дат-времени (считаем, что они в таймзоне предприятия) выдаст список всех поездок машинки (без треков), где будет вся общая информация по поездке, начальная и конечная точки,
 и добавьте текстовое "представление" этих точек, физический адрес.
Получить его можно через разные maps API (гугловский) или geocoders - Можно nominatim, но он тяжеловат...
На ваше усмотрение, какое подберёте.

20 - Добавьте утилиту (или какую-то "фичу" фреймворка, на ваше усмотрение),
для заданной id машинки, которая генерит её трек в реальном времени (дописывает точки в базу например раз в 10 секунд), похожий на настоящий.
Можно какие-нибудь сплайны задействовать - Задаются также длина трека в километрах, и максимальные скорость и ускорение.

По хорошему конечно треки надо к улицам привязывать, в карточных API есть роутинг, но он сейчас почти везде платный - Есть например GraphHopper Directions API — строит случайный маршрут по автодороге, в Яндексе есть
[https://yandex.ru/dev/maps/jsapi/doc/2.1/dg/concepts/router/about.html](https://yandex.ru/dev/maps/jsapi/doc/2.1/dg/concepts/router/about.html)

Неплохой бесплатный
[https://openrouteservice.org/](https://openrouteservice.org/)

Попробуйте добавить генерацию с роутингом.
