class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> Lines = new ArrayList<>();

        int index = 0;
        while (index < words.length){
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length){
                //If adding the next word exceeds the maxWidth, break
                if (count + 1 + words[last].length() > maxWidth) break;
                count += 1 + words[last].length();
                last++;
            }
            StringBuilder builder = new StringBuilder();
            builder.append(words[index]);
            int diff = last - index - 1;
        
        //If we are on the last line or the line has only one word, left-justify
        if (last == words.length || diff == 0){
            for (int i = index + 1; i < last; i++){
                builder.append(" ");
                builder.append(words[i]);
            }
            for (int i = builder.length(); i < maxWidth; i++){
                builder.append(" ");
            }
            }else{
                //Calculate Spaces
                int spaces = (maxWidth - count) / diff;
                int extraSpaces = (maxWidth - count) % diff;
                for (int i = index + 1; i < last; i++){
                    for ( int s = spaces; s > 0; s--){
                        builder.append(" ");
                    }
                    if (extraSpaces > 0){
                        builder.append(" ");
                        extraSpaces--;
                    }
                    builder.append(" ");
                    builder.append(words[i]);
                }
            }
            Lines.add(builder.toString());
            index = last;
        }
        return Lines;
    }
}

            
        

        
  