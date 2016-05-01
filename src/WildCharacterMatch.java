/**
 * Created by ted on 5/1/16.
 */
public class WildCharacterMatch implements MatchChain {
    private MatchChain chain;

    @Override
    public void setNextChain(MatchChain next) {
        chain = next;
    }

    @Override
    public boolean validateCharacter(String subject, int index) {
        boolean currentResponsibility = index < subject.length();
        return (chain == null) ? currentResponsibility :
                currentResponsibility && chain.validateCharacter(subject, index + 1);
    }
}
