package com.javatest.meta.other;

import java.util.*;

public class FindAllPeopleWithSecret {

    private static class Person {
        int person;
        Map<Integer, Set<Person>> visits;
//        Map<Person, Integer> first_time_visit;

        public Person(int person) {
            this.person = person;
            this.visits = new TreeMap<>();
//            this.first_time_visit = new HashMap<>();
        }

        public void add_person_visits(Person person, int time) {
//            int last_time = this.first_time_visit.getOrDefault(person, -1);
//            if(last_time > time || last_time == -1){
//                this.first_time_visit.put(person, time);
//                if(last_time != -1)
//                    this.visits.get(last_time).remove(person);
//                Set<Person> temp = this.visits.getOrDefault(time, new HashSet<>());
//                temp.add(person);
//                this.visits.put(time, temp);
//            }
            Set<Person> temp = this.visits.getOrDefault(time, new HashSet<>());
            temp.add(person);
            this.visits.put(time, temp);

        }

        @Override
        public int hashCode() {
            return Integer.hashCode(this.person);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person1)) return false;
            return this.person == person1.person;
        }
    }

    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));
        List<Person> list_persons = new ArrayList<>();
        Set<Person> who_know_secrets = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            list_persons.add(new Person(i));
        }
        // first meeting
        list_persons.get(0).add_person_visits(list_persons.get(firstPerson), 0);
        list_persons.get(firstPerson).add_person_visits(list_persons.get(0), 0);

        for (int[] meeting : meetings) {
            int first = meeting[0];
            int second = meeting[1];
            int time = meeting[2];
            list_persons.get(first).add_person_visits(list_persons.get(second), time);
            list_persons.get(second).add_person_visits(list_persons.get(first), time);
        }
        persons_who_knows(list_persons.get(0), who_know_secrets, new HashSet<>(), 0);
        List<Integer> result = new ArrayList<>();
        for (Person person : who_know_secrets)
            result.add(person.person);
        return result;
    }

    public static void persons_who_knows(Person person, Set<Person> who_knows, Set<String> visited, int time) {
        if (visited.contains(person.person + "p_t" + time))
            return;
        visited.add(person.person + "p_t" + time);
        who_knows.add(person);
        Map<Integer, Set<Person>> visits = person.visits;
        List<Integer> keys = new ArrayList<>(visits.keySet());

        for (int i = keys.size() - 1; i >= 0; --i) {
            int current_time = keys.get(i);
            if (current_time < time) {
                break;
            } else {
                for (Person p : visits.get(current_time)) {
                    persons_who_knows(p, who_knows, visited, current_time);
                }
            }
        }


//        for (Map.Entry<Integer, Set<Person>> entry : visits.entrySet()){
//            if(entry.getKey() >= time){
//                for (Person p : entry.getValue()){
//                    persons_who_knows(p, who_knows ,entry.getKey());
//                }
//            }
//        }
    }

    public static void main(String[] args) {
        int[][] meetings = new int[][]{{105, 18, 475}, {55, 56, 229}, {93, 38, 73}, {74, 6, 431}, {130, 95, 79}, {110, 34, 373}, {50, 20, 191}, {99, 70, 17}, {14, 21, 371}, {15, 24, 52}, {126, 98, 176}, {86, 102, 400}, {56, 72, 77}, {73, 111, 290}, {56, 74, 253}, {37, 55, 226}, {90, 52, 474}, {94, 65, 192}, {83, 103, 78}, {103, 86, 364}, {104, 68, 73}, {95, 19, 88}, {105, 130, 124}, {62, 122, 309}, {102, 98, 397}, {62, 3, 437}, {65, 102, 348}, {35, 81, 217}, {74, 83, 299}, {19, 20, 423}, {98, 75, 228}, {93, 9, 208}, {27, 47, 45}, {19, 58, 307}, {51, 52, 74}, {53, 107, 155}, {52, 46, 133}, {47, 62, 66}, {133, 8, 401}, {55, 107, 105}, {33, 117, 252}, {123, 73, 494}, {123, 34, 114}, {2, 130, 290}, {60, 126, 467}, {31, 32, 71}, {17, 27, 9}, {87, 61, 216}, {68, 127, 327}, {55, 122, 102}, {50, 62, 374}, {111, 27, 347}, {4, 125, 449}, {131, 118, 46}, {53, 93, 24}, {95, 6, 160}, {8, 3, 438}, {7, 13, 381}, {70, 100, 421}, {16, 46, 145}, {114, 7, 454}, {64, 122, 282}, {112, 63, 481}, {34, 90, 377}, {132, 37, 371}, {0, 111, 226}, {13, 121, 325}, {39, 26, 13}, {56, 125, 75}, {95, 40, 473}, {51, 121, 388}, {80, 116, 3}, {112, 30, 188}, {103, 34, 187}, {87, 33, 227}, {118, 6, 82}, {51, 129, 89}, {103, 78, 269}, {28, 79, 444}, {101, 106, 317}, {44, 82, 333}, {24, 95, 443}, {27, 30, 417}, {52, 99, 159}, {83, 69, 44}, {72, 53, 158}, {131, 11, 132}, {77, 14, 20}, {103, 92, 356}, {96, 60, 249}, {108, 18, 211}, {2, 119, 213}, {17, 124, 32}, {40, 19, 77}, {125, 40, 137}, {100, 60, 418}, {89, 51, 63}, {50, 86, 33}, {90, 20, 99}, {57, 49, 368}, {96, 7, 233}, {51, 36, 18}, {13, 95, 429}, {7, 33, 432}, {68, 92, 219}, {121, 94, 42}, {26, 132, 254}, {113, 102, 397}, {108, 126, 243}, {113, 111, 3}, {21, 119, 7}, {54, 128, 217}, {45, 114, 278}, {35, 8, 360}, {4, 69, 9}, {99, 40, 62}, {64, 128, 387}, {33, 122, 338}, {61, 122, 270}, {91, 68, 464}, {130, 11, 83}, {94, 57, 308}, {105, 88, 293}, {81, 76, 424}, {129, 96, 38}, {122, 7, 481}, {80, 67, 374}, {120, 86, 303}, {125, 119, 180}, {127, 73, 58}, {23, 53, 360}, {45, 123, 1}, {14, 102, 37}, {75, 96, 461}, {81, 127, 116}, {72, 101, 12}, {111, 125, 322}, {80, 44, 483}, {66, 96, 394}, {72, 123, 305}, {124, 128, 422}, {127, 132, 469}, {105, 14, 75}, {70, 27, 453}, {116, 98, 235}, {118, 86, 430}, {45, 31, 198}, {114, 1, 397}, {128, 10, 355}, {53, 92, 190}, {89, 119, 348}, {81, 48, 386}, {25, 43, 27}, {131, 78, 138}, {116, 58, 101}, {83, 2, 48}, {73, 55, 432}, {73, 32, 55}, {12, 13, 468}, {11, 86, 367}, {80, 73, 460}, {54, 57, 410}, {17, 77, 234}, {97, 61, 442}, {62, 14, 465}, {121, 2, 353}, {84, 106, 180}, {33, 126, 221}, {77, 48, 392}, {41, 32, 392}, {122, 131, 482}, {6, 31, 82}, {43, 40, 172}, {13, 78, 279}, {57, 18, 138}, {18, 79, 359}, {8, 73, 252}, {15, 77, 285}, {64, 50, 364}, {89, 54, 279}, {45, 11, 10}, {101, 125, 11}, {111, 30, 156}, {120, 9, 376}, {106, 11, 25}, {133, 50, 74}, {108, 95, 2}, {11, 133, 115}, {57, 79, 284}, {79, 7, 314}, {20, 117, 408}, {104, 82, 240}, {67, 115, 265}, {12, 22, 401}, {6, 50, 151}, {20, 44, 464}, {96, 48, 215}, {14, 118, 86}, {81, 86, 83}, {13, 53, 172}, {10, 128, 422}, {14, 32, 134}, {134, 50, 492}, {99, 128, 163}, {5, 119, 344}, {34, 14, 246}, {25, 67, 92}, {76, 6, 411}, {29, 77, 415}, {38, 46, 158}, {133, 125, 333}, {35, 36, 35}, {32, 70, 67}, {18, 73, 87}, {55, 43, 190}, {69, 119, 123}, {68, 3, 362}, {46, 9, 21}, {45, 83, 380}, {39, 112, 382}, {42, 27, 444}, {11, 118, 350}, {31, 84, 124}, {36, 133, 190}, {8, 77, 243}, {28, 51, 493}, {99, 107, 484}, {93, 81, 51}, {60, 12, 407}, {105, 13, 264}, {113, 110, 473}, {118, 14, 358}, {94, 75, 447}, {62, 119, 48}, {67, 124, 203}, {29, 127, 439}, {42, 61, 292}, {93, 46, 206}, {84, 87, 374}, {72, 87, 474}, {34, 48, 400}, {47, 5, 384}, {75, 97, 422}, {12, 56, 394}, {23, 102, 143}, {103, 132, 57}, {46, 21, 27}, {1, 51, 456}, {77, 45, 290}, {2, 51, 243}, {14, 22, 140}, {53, 121, 204}, {103, 117, 7}, {98, 53, 487}, {12, 16, 70}, {115, 111, 473}, {75, 74, 96}, {49, 23, 326}, {34, 75, 469}, {27, 3, 181}, {9, 40, 55}, {127, 115, 225}, {62, 117, 197}, {84, 40, 93}, {113, 11, 142}, {26, 120, 488}, {13, 45, 327}, {67, 73, 490}, {34, 21, 222}, {67, 106, 443}, {17, 62, 486}, {43, 65, 274}, {6, 101, 6}, {13, 102, 455}, {111, 55, 465}, {75, 112, 118}, {25, 10, 17}, {34, 98, 277}, {117, 37, 430}, {85, 106, 176}, {112, 13, 58}, {106, 35, 164}, {43, 61, 285}, {45, 22, 322}, {66, 55, 334}, {12, 111, 23}, {1, 65, 178}, {93, 8, 208}, {71, 68, 282}, {40, 92, 212}, {107, 34, 488}, {62, 2, 401}, {41, 120, 268}, {102, 120, 352}, {37, 42, 48}, {60, 107, 139}, {104, 91, 376}, {60, 18, 172}, {61, 17, 409}, {20, 67, 369}, {19, 3, 447}, {66, 118, 37}, {115, 55, 233}, {30, 105, 84}, {65, 127, 321}, {59, 105, 236}, {60, 24, 291}, {65, 50, 328}, {128, 63, 200}, {43, 133, 150}, {104, 83, 126}, {12, 36, 406}, {99, 132, 343}, {71, 92, 17}, {66, 113, 343}, {36, 127, 76}, {50, 129, 349}, {36, 75, 409}, {127, 131, 257}, {36, 23, 441}, {126, 83, 439}, {87, 75, 268}, {65, 17, 493}, {87, 116, 14}, {132, 125, 330}, {55, 126, 297}, {132, 78, 479}, {44, 128, 353}, {108, 35, 1}, {96, 10, 43}, {118, 116, 303}, {46, 82, 339}, {20, 12, 252}, {83, 112, 416}, {33, 86, 433}, {100, 79, 276}, {92, 38, 380}, {130, 54, 194}, {12, 11, 164}, {35, 79, 175}, {61, 3, 134}, {61, 3, 338}, {53, 5, 110}, {130, 79, 321}, {36, 7, 346}, {95, 25, 110}, {14, 95, 272}, {132, 83, 367}, {122, 119, 236}, {112, 111, 167}, {114, 52, 49}, {76, 115, 256}, {21, 65, 492}, {40, 72, 485}, {29, 25, 376}, {33, 77, 188}, {117, 122, 72}, {98, 41, 108}, {26, 64, 337}, {114, 11, 288}, {19, 49, 21}, {19, 81, 324}, {101, 13, 477}, {7, 115, 474}, {99, 31, 244}, {45, 43, 30}, {62, 61, 76}, {109, 91, 325}, {101, 117, 182}, {32, 45, 245}, {73, 108, 452}, {27, 36, 71}, {53, 123, 225}, {109, 61, 60}, {120, 41, 361}, {50, 13, 118}, {16, 39, 139}, {37, 18, 209}, {44, 16, 429}, {129, 77, 168}, {47, 21, 436}, {49, 108, 379}, {50, 84, 332}, {114, 12, 123}, {18, 63, 297}, {71, 117, 39}, {17, 106, 328}, {134, 75, 185}, {26, 123, 200}, {68, 91, 411}, {130, 12, 498}, {41, 53, 199}, {85, 13, 486}, {70, 16, 71}, {126, 94, 56}, {3, 57, 465}, {19, 30, 425}, {62, 79, 222}, {58, 33, 85}, {56, 9, 72}, {95, 30, 310}, {13, 95, 495}, {82, 53, 459}, {23, 77, 381}, {35, 95, 100}, {97, 61, 423}, {17, 22, 69}, {46, 59, 197}, {64, 108, 240}, {129, 0, 437}, {9, 47, 356}, {53, 46, 494}, {88, 53, 157}, {59, 21, 63}, {16, 86, 312}, {132, 19, 314}, {16, 45, 425}, {66, 108, 193}, {41, 61, 494}, {4, 7, 216}, {132, 82, 311}, {66, 42, 162}, {110, 27, 29}, {131, 80, 172}, {118, 13, 14}, {23, 118, 434}, {102, 79, 198}, {15, 1, 281}, {92, 110, 220}, {111, 120, 133}, {52, 50, 218}, {34, 2, 332}, {77, 39, 124}, {41, 98, 227}, {105, 6, 482}, {66, 10, 432}, {60, 113, 472}, {7, 55, 25}, {52, 47, 158}, {79, 64, 91}, {133, 75, 43}, {56, 98, 222}, {62, 35, 214}, {31, 9, 322}, {20, 105, 333}, {71, 129, 21}, {63, 51, 45}, {90, 121, 309}, {132, 117, 4}, {44, 1, 470}, {47, 70, 462}, {11, 130, 473}, {47, 19, 464}, {58, 129, 374}, {38, 123, 487}, {97, 75, 309}, {110, 98, 436}, {92, 23, 24}, {85, 91, 306}, {8, 85, 398}, {25, 130, 92}, {5, 13, 2}, {68, 122, 333}, {116, 125, 37}, {105, 78, 271}, {42, 36, 349}, {19, 58, 75}, {103, 83, 421}, {102, 27, 237}, {41, 130, 307}, {39, 0, 365}, {86, 39, 155}, {84, 8, 108}, {19, 32, 188}, {121, 42, 215}, {110, 84, 106}, {83, 119, 394}, {11, 21, 499}, {24, 35, 305}, {7, 11, 223}, {132, 37, 104}, {12, 16, 403}, {92, 57, 407}, {19, 58, 457}, {103, 86, 431}, {127, 67, 45}, {7, 28, 439}, {133, 87, 66}, {22, 99, 214}, {113, 70, 243}, {132, 69, 114}, {91, 61, 496}, {108, 73, 465}, {81, 77, 292}, {45, 96, 321}, {77, 72, 376}, {31, 57, 490}, {7, 85, 61}, {82, 32, 108}, {69, 16, 248}, {14, 70, 69}, {38, 122, 370}, {49, 86, 446}, {33, 46, 283}, {32, 15, 356}, {37, 85, 121}, {14, 39, 133}, {98, 36, 416}, {114, 22, 31}, {1, 67, 360}, {16, 113, 150}, {13, 23, 138}, {59, 105, 78}, {127, 123, 26}, {42, 107, 46}, {86, 84, 303}, {6, 9, 108}, {37, 72, 206}, {126, 18, 84}, {75, 64, 353}, {105, 4, 139}, {40, 86, 135}, {93, 63, 214}, {42, 15, 378}, {13, 89, 263}, {6, 23, 134}, {11, 83, 13}, {18, 49, 177}, {128, 133, 186}, {125, 111, 253}, {35, 93, 400}, {53, 114, 260}, {107, 66, 172}, {104, 38, 57}, {64, 65, 490}, {4, 77, 416}, {50, 122, 1}, {4, 64, 275}, {52, 84, 184}, {12, 63, 452}, {71, 126, 459}, {49, 108, 432}, {55, 117, 364}, {62, 39, 68}, {8, 39, 192}, {9, 107, 89}, {30, 25, 36}, {107, 35, 381}, {31, 55, 284}, {114, 101, 55}, {39, 45, 135}};


        System.out.println(findAllPeople(135, meetings /*new int[][]{{3,1,3},{1,2,2},{0,3,3}}*/, 12));
    }


    public List<Integer> findAllPeople2(int n, int[][] meetings, int firstPerson) {
        int[] groups = new int[100000];
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < n; ++i)
            groups[i] = i;
        groups[firstPerson] = 0;

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));

        int i = 0;
        while (i < meetings.length) {
            int currentTime = meetings[i][2];
            temp.clear();
            while (i < meetings.length && meetings[i][2] == currentTime) {
                int g1 = find(groups, meetings[i][0]);
                int g2 = find(groups, meetings[i][1]);
                groups[Math.max(g1, g2)] = Math.min(g1, g2);
                temp.add(meetings[i][0]);
                temp.add(meetings[i][1]);
                ++i;
            }
            for (int j = 0; j < temp.size(); ++j) {
                if (find(groups, temp.get(j)) != 0) {
                    groups[temp.get(j)] = temp.get(j);
                }
            }
        }

        for (int j = 0; j < n; ++j) {
            if (find(groups, j) == 0) result.add(j);
        }

        return result;
    }

    private int find(int[] groups, int index) {
        while (index != groups[index]) index = groups[index];
        return index;
    }
}
//You are given an integer n indicating
// there are n people numbered from 0 to n - 1.
// You are also given a 0-indexed 2D integer array meetings
// where meetings[i] = [xi, yi, timei] indicates that person
// xi and person yi have a meeting at timei. A person may attend
// multiple meetings at the same time. Finally, you are given an integer firstPerson.
//
//Person 0 has a secret and initially shares the secret with a person
// firstPerson at time 0. This secret is then shared every time a meeting
// takes place with a person that has the secret. More formally, for every meeting,
// if a person xi has the secret at timei, then they will share the secret with person yi, and vice versa.
//
//The secrets are shared instantaneously. That is, a person may
// receive the secret and share it with people in other meetings within the same time frame.
//
//Return a list of all the people that have the secret after all the
// meetings have taken place. You may return the answer in any order.