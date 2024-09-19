Приложение "Калькулятор отпускных" для онбординга на обучение в neoflex
Микросервис на SpringBoot + Java 17 c одним API:
GET "/calculacte"

Приложение принимает среднюю зарплату за 12 месяцев и количество дней отпуска - отвечает суммой отпускных, которые придут сотруднику.
При запросе также можно указать точные дни ухода в отпуск, тогда должен проводиться рассчет отпускных с учётом праздников и выходных.
Реализованы юнит тесты для проверки рассчета суммы отпускных.

Данные для рассчета отправляются в формате json. Пример: 
{
    "averageSalary": 719200,
    "vacationDays": 3,
    "vacationStartDate": "2024-12-20",
    "vacationEndDate": "2025-01-17"
}

Поле averageSalary является обязательным. При указании только количества дней (vacationDays), рассчет производится по количеству дней. 
При указании только дат отпуска (vacationStartDate, vacationEndDate) рассчет производится только по датам.
При указании всех трех полей приоритетность при рассчете отдается рассчету по точным датам. 
Если даты указаны неверно (ошибка BadRequestException), рассчет проводится по количеству дней.
