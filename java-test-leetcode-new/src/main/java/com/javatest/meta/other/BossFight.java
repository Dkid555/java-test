package com.javatest.meta.other;

import java.util.Arrays;

public class BossFight {
    private class Warrior implements Comparable<Warrior> {
        long health;
        long damage;

        public Warrior(int health, int damage) {
            this.health = health;
            this.damage = damage;
        }

        // Метод сравнения для сортировки воинов по их "силе" (здоровье * урон)
        public int compareTo(Warrior that) {
            return -Long.compare(this.health * this.damage, that.health * that.damage);
        }

        // Вычисление общего урона боссу с участием второго воина
        public double bossDamage(Warrior second, int B) {
            return (double) (this.damage + second.damage) * this.health / B + (double) second.damage * second.health / B;
        }
    }

    public double getMaxDamageDealt(int N, int[] H, int[] D, int B) {
        // Преобразование в массив воинов и сортировка по `health * damage` по убыванию
        Warrior[] warriors = new Warrior[N];
        for (int i = 0; i < N; i++) {
            warriors[i] = new Warrior(H[i], D[i]);
        }
        Arrays.sort(warriors);

        // Выбор двух "сильнейших" воинов для начала
        Warrior w1 = warriors[0];
        Warrior w2 = warriors[1];

        // Текущий максимально известный урон
        double max;
        // Инициализация нового найденного максимума на каждой итерации
        double newMax = bossDamage(w1, w2, B);

        // Повторение процесса замены воинов на лучших, пока урон не перестанет увеличиваться
        do {
            max = newMax;
            // Перебор всех воинов
            for (int i = 0; i < N; i++) {
                Warrior other = warriors[i];
                // Пропуск, если он уже один из 2 лучших воинов
                if (other == w1 || other == w2) {
                    continue;
                }
                // Если замена w2 увеличивает урон, заменить w2 и обновить newMax
                // Иначе, если замена w1 увеличивает урон, заменить w1 и обновить newMax
                if (bossDamage(w1, other, B) > newMax) {
                    w2 = other;
                    newMax = bossDamage(w1, w2, B);
                } else if (bossDamage(other, w2, B) > newMax) {
                    w1 = other;
                    newMax = bossDamage(w1, w2, B);
                }
            }
        } while (newMax > max);

        return max;
    }

    // Вычисление общего урона боссу для 2 воинов, учитывая обе комбинации
    public double bossDamage(Warrior w1, Warrior w2, int B) {
        return Math.max(w1.bossDamage(w2, B), w2.bossDamage(w1, B));
    }


}

class Main {
    public static void main(String[] args) {
        BossFight bossFight = new BossFight();

        System.out.println(bossFight.getMaxDamageDealt(3, new int[]{2, 1, 4}, new int[]{3, 1, 2}, 4));
    }
}
