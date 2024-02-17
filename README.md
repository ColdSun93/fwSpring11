# Фреймворк Spring (семинары)
## Урок 11. Spring Actuator. Настройка мониторинга с Prometheus и Grafana.
### Задание: По примерам показанным на семинаре:
1) Подключить к своему проекту зависимости actuator, registry-prometheus и micrometer.
2) Установить и подключить к проекту prometheus
3) Установить и подключить Grafana. В Grafana добавить пару точек контроля (Например: процессоное время приложения и количество запросов)
   
Формат сдачи: проект с добавленными зависимостями, [файл](https://github.com/ColdSun93/fwSpring11/blob/main/src/main/resources/static/prometheus.yml "Файл prometheus.yml") настройки Grafana и [скриншот](https://github.com/ColdSun93/fwSpring11/blob/main/src/main/resources/static/Grafana.png "скрин Grafana.png") Grafana с добавленными контрольными точками.

###   Задание со звездочкой:
- Проделать, то же самое с многомодульным проектом(добавить под контроль несколько модулей)
- Добавить собственную метрику.
