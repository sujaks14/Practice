package test.Amz;

import java.util.List;

/**

 Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

 You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

 Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

 For the last line of text, it should be left justified and no extra space is inserted between words.

 Note:

 A word is defined as a character sequence consisting of non-space characters only.
 Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 The input array words contains at least one word.

 */
import java.util.*;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<List<String>> list = new ArrayList<>();

        int currIndex = 0;
        int currentWordLength = -1;
        String one_space =" ";
        for(String word: words) {

           if(list.size() -1 < currIndex )  {
               list.add(new ArrayList<>());
           }

          if(list.size() + word.length()  <= maxWidth ) {

               list.get(currIndex).add(word);
                currentWordLength += word.length() ;

            if(list.size() + word.length() != maxWidth) {
                currentWordLength +=1;
            }

          }
          else {
             //Arrange the prev string with max width
              int totalwords = list.size();
              //find the length of each word
              if(list.size() == maxWidth) {
                  //nothing to do
                  currIndex = currIndex +1;
                  list.add(new ArrayList<>());
                  list.get(currIndex).add(word);
              }

              else {
                  //find out the space left between these two
              }


          }


        }


        return null;

    }


    public List<String> fullJustify1(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < words.length) {
            j = i;
            int currWidth = words[i].length();
            while (j+1 < words.length && (currWidth + words[j+1].length() +j+1-i) <= maxWidth) {
                j++;
                currWidth += words[j].length();
            }
            int spaces = 0, remain = 0;
            if (j > i) {// abc---de---fg--h (16-8) / 3 = 2, remain = 8 - 3*2
                spaces = (maxWidth - currWidth) / (j - i);
                remain = (maxWidth - currWidth) - spaces * (j - i);
            }
            StringBuilder sb = new StringBuilder();
            for (int k = i; k <= j; k++) {
                sb.append(words[k]);
                //last line
                if (j == words.length - 1 && sb.length() < maxWidth) {
                    sb.append(" ");
                } else if (k != j) { //not last line
                    for (int l = 0; l < spaces; l++)sb.append(" ");
                    if (remain-- > 0)sb.append(" ");
                }
            }
            int l = sb.length();// easy to change
            for (int k = 0; k < maxWidth-l; k++) {
                sb.append(" ");
            }
            list.add(sb.toString());
            i = j+1;
        }
        String last = list.get(list.size()-1);
        return list;
    }

}

