package uz.asz.cronwithoutannotation.mapper;

import org.springframework.jdbc.core.RowMapper;
import uz.asz.cronwithoutannotation.domain.Task;
import uz.asz.cronwithoutannotation.domain.enums.TaskStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskResultMapper implements RowMapper<Task> {

    public static final String ID = "ID";
    public static final String EXPRESSION = "EXPRESSION";
    public static final String NAME = "NAME";
    public static final String SQL = "SQL";
    public static final String STATUS = "STATUS";


    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task responseDTO = new Task();
        responseDTO.setId(rs.getLong(ID));
        responseDTO.setExpression(rs.getString(EXPRESSION));
        responseDTO.setName(rs.getString(NAME));
        responseDTO.setSql(rs.getString(SQL));
        responseDTO.setStatus(TaskStatus.valueOf(rs.getString(STATUS)));
        return responseDTO;
    }
}
