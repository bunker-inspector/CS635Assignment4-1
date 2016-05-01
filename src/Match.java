/**
 * Created by ted on 5/1/16.
 */
public class Match {
    MatchChain chain;

    class EmptyPatternException extends Exception {};

    Match(String pattern) throws EmptyPatternException {
        if(pattern.length() < 1) {
            throw new EmptyPatternException();
        }

        MatchChain current = matchChainFactory(pattern, 0);
        chain = current;

        for(int i = 1; i < pattern.length(); i++) {
            MatchChain next = matchChainFactory(pattern, i);
            current.setNextChain(next);
            current = next;
        }
    }

    MatchChain matchChainFactory(String pattern, int index) {
        switch(pattern.charAt(index)) {
            case '*':
                return (index == pattern.length() - 1) ? new WildSequenceMatch(null) :
                        new WildSequenceMatch(pattern.charAt(index + 1));
            case '.':
                return new WildCharacterMatch();
            default:
                return new LiteralCharacterMatch(pattern.charAt(index));
        }
    }

    int findFirstIn(String literal) {
        for(int i = 0; i < literal.length(); i++) {
            if (chain.validateCharacter(literal, i)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws EmptyPatternException {
        Match m = new Match("c*t");

        System.out.print(m.findFirstIn("llcat"));
    }

}
