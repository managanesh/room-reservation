package gani.ms.rrs.domain;

/**
 * Created by ganesh.vallabhaneni on 4/29/2015.
 */
public class Result {

    private String status;

    private String tarackingId;

    private Object body;

    private String timeElapsed;

    public Result(Object body) {
        this.body = body;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public String getTarackingId() {
        return tarackingId;
    }

    public void setTarackingId(String tarackingId) {
        this.tarackingId = tarackingId;
    }

    public String getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(String timeElapsed) {
        this.timeElapsed = timeElapsed;
    }
}
