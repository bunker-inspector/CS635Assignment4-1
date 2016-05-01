/**
 * Created by ted on 5/1/16.
 */
public class LiteralCharacterMatch implements MatchChain {
    private MatchChain chain;
    char expectedCharacter;

    LiteralCharacterMatch(char c) {
        expectedCharacter = c;
    }

    @Override
    public void setNextChain(MatchChain next) {
        chain = next;
    }

    @Override
    public boolean validateCharacter(String subject, int index) {
        boolean currentResponsibility = (subject.charAt(index) == expectedCharacter);
        return (chain == null) ? currentResponsibility :
                currentResponsibility && chain.validateCharacter(subject, index + 1);
    }
}
