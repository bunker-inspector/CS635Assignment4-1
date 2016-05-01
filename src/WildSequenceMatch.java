/**
 * Created by ted on 5/1/16.
 */
public class WildSequenceMatch implements MatchChain {
    private MatchChain chain;
    private Character stopValue;

    WildSequenceMatch(Character c) {
        stopValue = c;
    }

    @Override
    public void setNextChain(MatchChain next) {
        chain = next;
    }

    @Override
    public boolean validateCharacter(String subject, int index) {
        return (chain == null) ? true : chain.validateCharacter(subject, subject.indexOf(stopValue, index));
    }
}
