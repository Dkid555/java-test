package com.Amazon.Matrix;

import java.util.*;

public class WordSearchII_not_fast {

    private static class Letter{

        public Letter(Character letter, Map<Character, Set<Letter>> neighbors, int row, int column) {
            this.letter = letter;
            this.neighbors = neighbors;
            this.row = row;
            this.column = column;
        }

        public Character getLetter() {
            return letter;
        }

        public void setLetter(Character letter) {
            this.letter = letter;
        }

        public Map<Character, Set<Letter>> getNeighbors() {
            return neighbors;
        }

        public void setNeighbors(Map<Character, Set<Letter>> neighbors) {
            this.neighbors = neighbors;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        private Character letter;
        private Map<Character, Set<Letter>> neighbors;

        private int row;
        private int column;
    }

    private static class Board{
        Map<Character, Set<Letter>> board;
        int size;
        public boolean exist(String word) {
            if(this.board.isEmpty() || this.size < word.length())
                return false;
            return BFS(this.board,0, word, new Stack<>(), new HashSet<>(), null);
        }
        private static boolean BFS (Map<Character, Set<Letter>> map_search, int i, String word,
                                     Stack<Integer> stack, Set<Letter> visited, Letter current_letter){
            if(visited.contains(current_letter))
                return false;
            visited.add(current_letter);

            if(i >= word.length()){
                stack.push(1);
                return true;
            }
            if(!stack.isEmpty())
                return true;
            char current = word.charAt(i);
            if(!map_search.containsKey(current)){
                return false;
            }
            for(Letter letter : map_search.get(current)){
                BFS(letter.getNeighbors(), i + 1, word, stack, new HashSet<>(visited), letter);
                visited.remove(letter);
            }
            return !stack.isEmpty();
        }
        public void formBoard(char[][] board_orig){
            Map<String, Letter> map_of_form = new HashMap<>();
            Map<Character, Set<Letter>> map_to_start_search = new HashMap<>();
            this.size = board_orig[0].length * board_orig.length;
            int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
            for (int row = 0; row < board_orig.length; ++row){
                for (int column = 0; column < board_orig[row].length; ++column){
                    Letter current;
                    String current_position = row + "RC"+column;
                    char current_char = board_orig[row][column];
                    if(map_of_form.containsKey(current_position)){
                        current = map_of_form.get(current_position);
                    }else {
                        current = new Letter(current_char, new HashMap<>(), row, column);
                        map_of_form.put(current_position, current);
                        map_to_start_search.putIfAbsent(current_char, new HashSet<>());
                        map_to_start_search.get(current_char).add(current);
                    } // соседи
                    for(int[] direction : directions){
                        String position_neighbor = (row + direction[0]) + "RC" + (column + direction[1]);
                        Letter neighbor = null;
                        char neighbor_char = 0;
                        if(map_of_form.containsKey(position_neighbor)){
                            neighbor = map_of_form.get(position_neighbor);
                            neighbor_char = board_orig[row + direction[0]][column + direction[1]];
                        }else { // если еще не задан
                            if(row + direction[0] < board_orig.length && 0 <= row + direction[0] &&
                                    column + direction[1] < board_orig[row].length  && column + direction[1] >= 0){
                                neighbor_char = board_orig[row + direction[0]][column + direction[1]];
                                neighbor = new Letter(neighbor_char, new HashMap<>(), row + direction[0],
                                        column + direction[1]);
                                map_of_form.put(position_neighbor, neighbor);
                                map_to_start_search.putIfAbsent(neighbor_char, new HashSet<>());
                                map_to_start_search.get(neighbor_char).add(neighbor);
                            }
                        }
                        if(neighbor != null && neighbor_char != 0){
                            current.getNeighbors().putIfAbsent(neighbor_char, new HashSet<>());
                            current.getNeighbors().get(neighbor_char).add(neighbor);
                        }
                    }
                }
            }
            this.board = map_to_start_search;
        }
    }



//    public static List<String> findWords(char[][] board, String[] words) {
//        Board board_ = new Board();
//        board_.formBoard(board);
//        List<String> result = new ArrayList<>();
//
//        for (String word : words){
//            if(board_.exist(word)){
//                result.add(word);
//            }
//        }
//        return result;
//    }
public static List<String> findWords(char[][] board, String[] words) {
    Board board_ = new Board();
    board_.formBoard(board);

    // Creating a thread-safe list
    List<String> result = Collections.synchronizedList(new ArrayList<>());

    // Determine the number of threads
    int numThreads = Runtime.getRuntime().availableProcessors(); // Adjust as needed

    // Divide the words among threads
    int wordsPerThread = (int) Math.ceil((double) words.length / numThreads);

    // Create and start threads
    List<Thread> threads = new ArrayList<>();
    for (int i = 0; i < numThreads; i++) {
        int start = i * wordsPerThread;
        int end = Math.min((i + 1) * wordsPerThread, words.length);
        Thread thread = new Thread(() -> {
            for (int j = start; j < end; j++) {
                String word = words[j];
                if (board_.exist(word)) {
                    result.add(word);
                }
            }
        });
        thread.start();
        threads.add(thread);
    }

    // Wait for all threads to finish
    for (Thread thread : threads) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    return result;
}


    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        char[][] board2 = {{'a', 'b'}, {'a', 'a'}};
        String[] words2 = {"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        char[][] board3 = {
                {'b','a','b','a','b','a','b','a','b','a'},
                {'a','b','a','b','a','b','a','b','a','b'},
                {'b','a','b','a','b','a','b','a','b','a'},
                {'a','b','a','b','a','b','a','b','a','b'},
                {'b','a','b','a','b','a','b','a','b','a'},
                {'a','b','a','b','a','b','a','b','a','b'},
                {'b','a','b','a','b','a','b','a','b','a'},
                {'a','b','a','b','a','b','a','b','a','b'},
                {'b','a','b','a','b','a','b','a','b','a'},
                {'a','b','a','b','a','b','a','b','a','b'}
        };

        String[] words3 = {"ababababaa","ababababab","ababababac","ababababad","ababababae","ababababaf","ababababag","ababababah","ababababai","ababababaj","ababababak","ababababal","ababababam","ababababan","ababababao","ababababap","ababababaq","ababababar","ababababas","ababababat","ababababau","ababababav","ababababaw","ababababax","ababababay","ababababaz","ababababba","ababababbb","ababababbc","ababababbd","ababababbe","ababababbf","ababababbg","ababababbh","ababababbi","ababababbj","ababababbk","ababababbl","ababababbm","ababababbn","ababababbo","ababababbp","ababababbq","ababababbr","ababababbs","ababababbt","ababababbu","ababababbv","ababababbw","ababababbx","ababababby","ababababbz","ababababca","ababababcb","ababababcc","ababababcd","ababababce","ababababcf","ababababcg","ababababch","ababababci","ababababcj","ababababck","ababababcl","ababababcm","ababababcn","ababababco","ababababcp","ababababcq","ababababcr","ababababcs","ababababct","ababababcu","ababababcv","ababababcw","ababababcx","ababababcy","ababababcz","ababababda","ababababdb","ababababdc","ababababdd","ababababde","ababababdf","ababababdg","ababababdh","ababababdi","ababababdj","ababababdk","ababababdl","ababababdm","ababababdn","ababababdo","ababababdp","ababababdq","ababababdr","ababababds","ababababdt","ababababdu","ababababdv","ababababdw","ababababdx","ababababdy","ababababdz","ababababea","ababababeb","ababababec","ababababed","ababababee","ababababef","ababababeg","ababababeh","ababababei","ababababej","ababababek","ababababel","ababababem","ababababen","ababababeo","ababababep","ababababeq","ababababer","ababababes","ababababet","ababababeu","ababababev","ababababew","ababababex","ababababey","ababababez","ababababfa","ababababfb","ababababfc","ababababfd","ababababfe","ababababff","ababababfg","ababababfh","ababababfi","ababababfj","ababababfk","ababababfl","ababababfm","ababababfn","ababababfo","ababababfp","ababababfq","ababababfr","ababababfs","ababababft","ababababfu","ababababfv","ababababfw","ababababfx","ababababfy","ababababfz","ababababga","ababababgb","ababababgc","ababababgd","ababababge","ababababgf","ababababgg","ababababgh","ababababgi","ababababgj","ababababgk","ababababgl","ababababgm","ababababgn","ababababgo","ababababgp","ababababgq","ababababgr","ababababgs","ababababgt","ababababgu","ababababgv","ababababgw","ababababgx","ababababgy","ababababgz","ababababha","ababababhb","ababababhc","ababababhd","ababababhe","ababababhf","ababababhg","ababababhh","ababababhi","ababababhj","ababababhk","ababababhl","ababababhm","ababababhn","ababababho","ababababhp","ababababhq","ababababhr","ababababhs","ababababht","ababababhu","ababababhv","ababababhw","ababababhx","ababababhy","ababababhz","ababababia","ababababib","ababababic","ababababid","ababababie","ababababif","ababababig","ababababih","ababababii","ababababij","ababababik","ababababil","ababababim","ababababin","ababababio","ababababip","ababababiq","ababababir","ababababis","ababababit","ababababiu","ababababiv","ababababiw","ababababix","ababababiy","ababababiz","ababababja","ababababjb","ababababjc","ababababjd","ababababje","ababababjf","ababababjg","ababababjh","ababababji","ababababjj","ababababjk","ababababjl","ababababjm","ababababjn","ababababjo","ababababjp","ababababjq","ababababjr","ababababjs","ababababjt","ababababju","ababababjv","ababababjw","ababababjx","ababababjy","ababababjz","ababababka","ababababkb","ababababkc","ababababkd","ababababke","ababababkf","ababababkg","ababababkh","ababababki","ababababkj","ababababkk","ababababkl","ababababkm","ababababkn","ababababko","ababababkp","ababababkq","ababababkr","ababababks","ababababkt","ababababku","ababababkv","ababababkw","ababababkx","ababababky","ababababkz","ababababla","abababablb","abababablc","ababababld","abababable","abababablf","abababablg","abababablh","ababababli","abababablj","abababablk","ababababll","abababablm","ababababln","abababablo","abababablp","abababablq","abababablr","ababababls","abababablt","abababablu","abababablv","abababablw","abababablx","abababably","abababablz","ababababma","ababababmb","ababababmc","ababababmd","ababababme","ababababmf","ababababmg","ababababmh","ababababmi","ababababmj","ababababmk","ababababml","ababababmm","ababababmn","ababababmo","ababababmp","ababababmq","ababababmr","ababababms","ababababmt","ababababmu","ababababmv","ababababmw","ababababmx","ababababmy","ababababmz","ababababna","ababababnb","ababababnc","ababababnd","ababababne","ababababnf","ababababng","ababababnh","ababababni","ababababnj","ababababnk","ababababnl","ababababnm","ababababnn","ababababno","ababababnp","ababababnq","ababababnr","ababababns","ababababnt","ababababnu","ababababnv","ababababnw","ababababnx","ababababny","ababababnz","ababababoa","ababababob","ababababoc","ababababod","ababababoe","ababababof","ababababog","ababababoh","ababababoi","ababababoj","ababababok","ababababol","ababababom","ababababon","ababababoo","ababababop","ababababoq","ababababor","ababababos","ababababot","ababababou","ababababov","ababababow","ababababox","ababababoy","ababababoz","ababababpa","ababababpb","ababababpc","ababababpd","ababababpe","ababababpf","ababababpg","ababababph","ababababpi","ababababpj","ababababpk","ababababpl","ababababpm","ababababpn","ababababpo","ababababpp","ababababpq","ababababpr","ababababps","ababababpt","ababababpu","ababababpv","ababababpw","ababababpx","ababababpy","ababababpz","ababababqa","ababababqb","ababababqc","ababababqd","ababababqe","ababababqf","ababababqg","ababababqh","ababababqi","ababababqj","ababababqk","ababababql","ababababqm","ababababqn","ababababqo","ababababqp","ababababqq","ababababqr","ababababqs","ababababqt","ababababqu","ababababqv","ababababqw","ababababqx","ababababqy","ababababqz","ababababra","ababababrb","ababababrc","ababababrd","ababababre","ababababrf","ababababrg","ababababrh","ababababri","ababababrj","ababababrk","ababababrl","ababababrm","ababababrn","ababababro","ababababrp","ababababrq","ababababrr","ababababrs","ababababrt","ababababru","ababababrv","ababababrw","ababababrx","ababababry","ababababrz","ababababsa","ababababsb","ababababsc","ababababsd","ababababse","ababababsf","ababababsg","ababababsh","ababababsi","ababababsj","ababababsk","ababababsl","ababababsm","ababababsn","ababababso","ababababsp","ababababsq","ababababsr","ababababss","ababababst","ababababsu","ababababsv","ababababsw","ababababsx","ababababsy","ababababsz","ababababta","ababababtb","ababababtc","ababababtd","ababababte","ababababtf","ababababtg","ababababth","ababababti","ababababtj","ababababtk","ababababtl","ababababtm","ababababtn","ababababto","ababababtp","ababababtq","ababababtr","ababababts","ababababtt","ababababtu","ababababtv","ababababtw","ababababtx","ababababty","ababababtz","ababababua","ababababub","ababababuc","ababababud","ababababue","ababababuf","ababababug","ababababuh","ababababui","ababababuj","ababababuk","ababababul","ababababum","ababababun","ababababuo","ababababup","ababababuq","ababababur","ababababus","ababababut","ababababuu","ababababuv","ababababuw","ababababux","ababababuy","ababababuz","ababababva","ababababvb","ababababvc","ababababvd","ababababve","ababababvf","ababababvg","ababababvh","ababababvi","ababababvj","ababababvk","ababababvl","ababababvm","ababababvn","ababababvo","ababababvp","ababababvq","ababababvr","ababababvs","ababababvt","ababababvu","ababababvv","ababababvw","ababababvx","ababababvy","ababababvz","ababababwa","ababababwb","ababababwc","ababababwd","ababababwe","ababababwf","ababababwg","ababababwh","ababababwi","ababababwj","ababababwk","ababababwl","ababababwm","ababababwn","ababababwo","ababababwp","ababababwq","ababababwr","ababababws","ababababwt","ababababwu","ababababwv","ababababww","ababababwx","ababababwy","ababababwz","ababababxa","ababababxb","ababababxc","ababababxd","ababababxe","ababababxf","ababababxg","ababababxh","ababababxi","ababababxj","ababababxk","ababababxl","ababababxm","ababababxn","ababababxo","ababababxp","ababababxq","ababababxr","ababababxs","ababababxt","ababababxu","ababababxv","ababababxw","ababababxx","ababababxy","ababababxz","ababababya","ababababyb","ababababyc","ababababyd","ababababye","ababababyf","ababababyg","ababababyh","ababababyi","ababababyj","ababababyk","ababababyl","ababababym","ababababyn","ababababyo","ababababyp","ababababyq","ababababyr","ababababys","ababababyt","ababababyu","ababababyv","ababababyw","ababababyx","ababababyy","ababababyz","ababababza","ababababzb","ababababzc","ababababzd","ababababze","ababababzf","ababababzg","ababababzh","ababababzi","ababababzj","ababababzk","ababababzl","ababababzm","ababababzn","ababababzo","ababababzp","ababababzq","ababababzr","ababababzs","ababababzt","ababababzu","ababababzv","ababababzw","ababababzx","ababababzy","ababababzz"};
        System.out.println(findWords(board3, words2));
    }
}
