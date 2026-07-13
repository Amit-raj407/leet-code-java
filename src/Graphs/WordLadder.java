package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if(!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] chars = word.toCharArray();

                for(int j = 0; j < chars.length; j++) {
                    char original = chars[j];

                    for(char c = 'a'; c <= 'z'; c++) {
                        if(c == original)
                            continue;
                        chars[j] = c;
                        String nextWord = new String(chars);

                        if(nextWord.equals(endWord)) {
                            return level + 1;
                        }

                        if(wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                            visited.add(nextWord);
                            queue.offer(nextWord);
                        }
                    }
                    chars[j] = original;
                }
            }
            level++;
        }

        return 0;
    }
}


/*

Word Ladder (LeetCode 127)

A Word Ladder is the shortest transformation sequence problem.

You are given:

beginWord
endWord
wordList

You can transform one word into another by changing exactly one character at a time.

Rules:

Only one character can change in each step.
Every intermediate word must exist in wordList.
Return the length of the shortest transformation sequence.
Return 0 if transformation is impossible.
Example
beginWord = "hit"
endWord   = "cog"

wordList = ["hot","dot","dog","lot","log","cog"]

Transformation:

hit
 ↓
hot
 ↓
dot
 ↓
dog
 ↓
cog

Length = 5

Why BFS?

This is an unweighted graph.

Think of every word as a node.

Two words have an edge if they differ by exactly one character.

Example:

hot
 |
dot
 |
dog
 |
cog

Whenever we need the shortest path in an unweighted graph, we use BFS.

Graph Construction (Implicit)

We do not build the graph.

Instead, for every word, generate all possible neighboring words.

Example:

hot

Change first letter:
aot
bot
cot
...
zot

Change second letter:
hat
hbt
...
hzt

Change third letter:
hoa
hob
...
hoz

If a generated word exists in the dictionary, it is a valid neighbor.

BFS Algorithm
Put beginWord into queue.
Maintain a visited set.
For every word:
Try changing every character.
Generate neighbors.
If neighbor == endWord → return answer.
Otherwise push into queue.
If queue becomes empty → return 0.
Dry Run
begin = hit

Queue:
[hit]

Level = 1
Level 1
hit

Generate

ait
bit
...
hot  ← exists
...
zit

Queue

hot

Level = 2

Level 2
hot

Generate

dot
lot

Queue

dot
lot

Level = 3

Level 3

Process dot

dog

Process lot

log

Queue

dog
log

Level = 4

Level 4

Process dog

cog

Found destination.

Answer

5
Complexity

Suppose

N = number of words
L = word length

For every word:

L positions
26 letters

Time

O(N × L × 26)

≈ O(NL)

Space

O(N)

*/