package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

public class VotingMachine {
    private Map<String, Integer> votes;

    public VotingMachine() {
        votes = new HashMap<>();
    }

    // Add a candidate to the election
    public void addCandidate(String candidate) {
        if (!votes.containsKey(candidate)) {
            votes.put(candidate, 0);
        }
    }

    // Cast a vote for a candidate
    public boolean castVote(String candidate) {
        if (votes.containsKey(candidate)) {
            votes.put(candidate, votes.get(candidate) + 1);
            return true;
        }
        return false;
    }

    // Get the winner of the election
    public String getWinner() {
        String winner = null;
        int maxVotes = 0;

        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        return winner + " WINS with " + maxVotes + " votes!!";
    }
}
