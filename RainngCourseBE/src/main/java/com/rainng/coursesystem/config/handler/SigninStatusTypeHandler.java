//package com.rainng.coursesystem.config.handler;
//
//import com.rainng.coursesystem.model.entity.SigninRecordEntity;
//import com.rainng.coursesystem.model.entity.SigninStatusEntity;
//import org.apache.ibatis.type.BaseTypeHandler;
//import org.apache.ibatis.type.JdbcType;
//import java.sql.CallableStatement;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class SigninStatusTypeHandler extends BaseTypeHandler<SigninStatusEntity.SigninStatus> {
//
//    @Override
//    public void setNonNullParameter(PreparedStatement ps, int i, SigninStatusEntity.SigninStatus parameter, JdbcType jdbcType) throws SQLException {
//        ps.setString(i, parameter.name());
//    }
//
//    @Override
//    public SigninStatusEntity.SigninStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
//        String status = rs.getString(columnName);
//        return status == null ? null : SigninRecordEntity.fromString(status);
//    }
//
//    @Override
//    public SigninStatusEntity.SigninStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
//        String status = rs.getString(columnIndex);
//        return status == null ? null : SigninRecordEntity.fromString(status);
//    }
//
//    @Override
//    public SigninStatusEntity.SigninStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
//        String status = cs.getString(columnIndex);
//        return status == null ? null : SigninRecordEntity.fromString(status);
//    }
//}
