package Utils;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmulatorResponse {

    private String messageType;
    private RecordingScope recordingScope;
    private List<File> files;

    private List<String> packages;

    public List<String> getPackages() {
        return packages;
    }

    public void setPackages(List<String> packages) {
        this.packages = packages;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public RecordingScope getRecordingScope() {
        return recordingScope;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setRecordingScope(RecordingScope recordingScope) {
        this.recordingScope = recordingScope;
    }

    public void setFiles(List<File> files){
        this.files = files;
    }

    public static class RecordingScope {

       private String tenantId;
       private Long taskId;
       private String taskExecutionId;
       private String testSuiteResultId;
       private Long applicationVersionId;


       public String getTenantId() {
           return tenantId;
       }

       public void setTenantId(String tenantId) {
           this.tenantId = tenantId;
       }

       public Long getTaskId() {
           return taskId;
       }

       public void setTaskId(Long taskId) {
           this.taskId = taskId;
       }

       public String getTaskExecutionId() {
           return taskExecutionId;
       }

       public void setTaskExecutionId(String taskExecutionId) {
           this.taskExecutionId = taskExecutionId;
       }

       public String getTestSuiteResultId() {
           return testSuiteResultId;
       }

       public void setTestSuiteResultId(String testSuiteResultId) {
           this.testSuiteResultId = testSuiteResultId;
       }

       public Long getApplicationVersionId() {
           return applicationVersionId;
       }

       public void setApplicationVersionId(Long applicationVersionId) {
           this.applicationVersionId = applicationVersionId;
       }
   }

    public static class File {

        private String filename;
        private int pack;
        private int visits;

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public void setPack(int pack) {
            this.pack = pack;
        }

        public void setVisits(int visits) {
            this.visits = visits;
        }

        public String getFilename() {
            return filename;
        }

        public int getPack() {
            return pack;
        }

        public int getVisits() {
            return visits;
        }
    }
}