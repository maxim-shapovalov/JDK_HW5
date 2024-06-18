/*
���� ���������� ��������� ����� ������ �������� �����, ����� ������ ��������� ����� ������� ��������.
����� ����� �� ����� ����� ������ ����� ��������� ���������.
������ ������� ����� ���� ����, ���� ����������.
������� ����� ���� ������ �����, ����� ������ ��� ����� � ������ ������ � �����.
������� �� ����� ���� ��� ���� ������, �� ����������� �� ����������� (����� �� ���������)
������� � ���� ���� ����� ��������. ������ ������� ������ ������ ��� ����


 */
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore[] forks = new Semaphore[5];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Semaphore(1);
        }

        Philosopher[] philosophers = new Philosopher[5];
        philosophers[0] = new Philosopher("���������", 1, forks[0], 2, forks[1]);
        philosophers[1] = new Philosopher("������", 2, forks[1], 3, forks[2]);
        philosophers[2] = new Philosopher("��������", 3, forks[2], 4, forks[3]);
        philosophers[3] = new Philosopher("�������", 4, forks[3], 5, forks[4]);
        philosophers[4] = new Philosopher("��������", 5, forks[4], 1, forks[0]);

        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }
}
