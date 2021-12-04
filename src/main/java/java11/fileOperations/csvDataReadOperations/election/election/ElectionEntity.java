package java11.fileOperations.csvDataReadOperations.election.election;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author Created by nichaurasia
 * @create on Wednesday, September/30/2020 at 9:38 AM
 */

@Getter
@Setter
@ToString
public class ElectionEntity {
    private String state;
    private String assembly;
    private String candidate;
    private String party;
    private int votes;

    public ElectionEntity(String state, String assembly, String candidate, String party, int votes) {
        this.state = state;
        this.assembly = assembly;
        this.candidate = candidate;
        this.party = party;
        this.votes = votes;
    }

}
