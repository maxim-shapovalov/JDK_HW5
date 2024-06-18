/*
Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
Вилки лежат на столе между каждой парой ближайших философов.
Каждый философ может либо есть, либо размышлять.
Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза


 */
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore[] forks = new Semaphore[5];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Semaphore(1);
        }

        Philosopher[] philosophers = new Philosopher[5];
        philosophers[0] = new Philosopher("Инокентий", 1, forks[0], 2, forks[1]);
        philosophers[1] = new Philosopher("Сергей", 2, forks[1], 3, forks[2]);
        philosophers[2] = new Philosopher("Валентин", 3, forks[2], 4, forks[3]);
        philosophers[3] = new Philosopher("Николай", 4, forks[3], 5, forks[4]);
        philosophers[4] = new Philosopher("Евлампий", 5, forks[4], 1, forks[0]);

        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }
}
