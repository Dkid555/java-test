package com.leet_easy;

public class MaximizetheConfusionofanExam {

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int answer = 0;
        int[] count = new int[2]; // F - 0, T - 1
        int max_count = 0; // последовательности T или F
        for (int i = 0, r = 0; r < answerKey.length(); r++) {
            max_count = Math.max(max_count, ++count[answerKey.charAt(r) == 'T' ? 1 : 0]);
            while (max_count + k < r - i + 1) { // вычисляем длинну
                --count[answerKey.charAt(i++) == 'T' ? 1 : 0];
            }
            answer = Math.max(answer, r - i + 1);
        }
        return answer;
    }

    /////
    public static int maxConsecutiveAnswers2(String answerKey, int k) {
        char[] chars = answerKey.toCharArray();
        int result = 0, max = 0, count[] = new int[128];
        for (int i = 0; i < chars.length; i++)
            if (result - (max = Math.max(max, ++count[chars[i]])) < k) result++;
            else count[chars[i - result]]--;
        return result;
    }
///////////////

    public static int SlidingWindow(String answerKey, int k, char letter) {
        int right = 0;
        int left = 0;
        int count = 0;
        int answer = 0;

        for (right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) == letter) {
                count++;
            }
            if (count > k) {
                if (answerKey.charAt(left) == letter) {
                    count--;
                }
                left++;
            }
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }

    public static int maxConsecutiveAnswers3(String answerKey, int k) {
        return Math.max(SlidingWindow(answerKey, k, 'T'), SlidingWindow(answerKey, k, 'F'));
    }
////////////////


    public static void main(String[] args) {
        System.out.println(maxConsecutiveAnswers3("TTFTTFTT", 1));
    }
}


//A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F'
// denoting false. He wants to confuse the students by maximizing the number of consecutive
// questions with the same answer (multiple trues or multiple falses in a row).
//
//You are given a string answerKey, where answerKey[i] is the original answer to the ith question.
// In addition, you are given an integer k, the maximum number of times you may perform the following operation:
//
//Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').
//Return the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at most k times.