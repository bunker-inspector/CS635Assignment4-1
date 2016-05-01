/**
 * Created by ted on 5/1/16.
 */
public interface MatchChain {
    void setNextChain(MatchChain next);
    boolean validateCharacter(String subject, int index);
}
