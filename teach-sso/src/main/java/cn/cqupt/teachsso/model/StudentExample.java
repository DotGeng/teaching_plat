package cn.cqupt.teachsso.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andStudentIdIsNull() {
            addCriterion("student_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("student_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(Integer value) {
            addCriterion("student_id =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(Integer value) {
            addCriterion("student_id <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(Integer value) {
            addCriterion("student_id >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("student_id >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(Integer value) {
            addCriterion("student_id <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(Integer value) {
            addCriterion("student_id <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<Integer> values) {
            addCriterion("student_id in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<Integer> values) {
            addCriterion("student_id not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(Integer value1, Integer value2) {
            addCriterion("student_id between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("student_id not between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentNoIsNull() {
            addCriterion("student_no is null");
            return (Criteria) this;
        }

        public Criteria andStudentNoIsNotNull() {
            addCriterion("student_no is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNoEqualTo(String value) {
            addCriterion("student_no =", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotEqualTo(String value) {
            addCriterion("student_no <>", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoGreaterThan(String value) {
            addCriterion("student_no >", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoGreaterThanOrEqualTo(String value) {
            addCriterion("student_no >=", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoLessThan(String value) {
            addCriterion("student_no <", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoLessThanOrEqualTo(String value) {
            addCriterion("student_no <=", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoLike(String value) {
            addCriterion("student_no like", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotLike(String value) {
            addCriterion("student_no not like", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoIn(List<String> values) {
            addCriterion("student_no in", values, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotIn(List<String> values) {
            addCriterion("student_no not in", values, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoBetween(String value1, String value2) {
            addCriterion("student_no between", value1, value2, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotBetween(String value1, String value2) {
            addCriterion("student_no not between", value1, value2, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNameIsNull() {
            addCriterion("student_name is null");
            return (Criteria) this;
        }

        public Criteria andStudentNameIsNotNull() {
            addCriterion("student_name is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNameEqualTo(String value) {
            addCriterion("student_name =", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotEqualTo(String value) {
            addCriterion("student_name <>", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameGreaterThan(String value) {
            addCriterion("student_name >", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameGreaterThanOrEqualTo(String value) {
            addCriterion("student_name >=", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLessThan(String value) {
            addCriterion("student_name <", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLessThanOrEqualTo(String value) {
            addCriterion("student_name <=", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLike(String value) {
            addCriterion("student_name like", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotLike(String value) {
            addCriterion("student_name not like", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameIn(List<String> values) {
            addCriterion("student_name in", values, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotIn(List<String> values) {
            addCriterion("student_name not in", values, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameBetween(String value1, String value2) {
            addCriterion("student_name between", value1, value2, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotBetween(String value1, String value2) {
            addCriterion("student_name not between", value1, value2, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentPswdIsNull() {
            addCriterion("student_pswd is null");
            return (Criteria) this;
        }

        public Criteria andStudentPswdIsNotNull() {
            addCriterion("student_pswd is not null");
            return (Criteria) this;
        }

        public Criteria andStudentPswdEqualTo(String value) {
            addCriterion("student_pswd =", value, "studentPswd");
            return (Criteria) this;
        }

        public Criteria andStudentPswdNotEqualTo(String value) {
            addCriterion("student_pswd <>", value, "studentPswd");
            return (Criteria) this;
        }

        public Criteria andStudentPswdGreaterThan(String value) {
            addCriterion("student_pswd >", value, "studentPswd");
            return (Criteria) this;
        }

        public Criteria andStudentPswdGreaterThanOrEqualTo(String value) {
            addCriterion("student_pswd >=", value, "studentPswd");
            return (Criteria) this;
        }

        public Criteria andStudentPswdLessThan(String value) {
            addCriterion("student_pswd <", value, "studentPswd");
            return (Criteria) this;
        }

        public Criteria andStudentPswdLessThanOrEqualTo(String value) {
            addCriterion("student_pswd <=", value, "studentPswd");
            return (Criteria) this;
        }

        public Criteria andStudentPswdLike(String value) {
            addCriterion("student_pswd like", value, "studentPswd");
            return (Criteria) this;
        }

        public Criteria andStudentPswdNotLike(String value) {
            addCriterion("student_pswd not like", value, "studentPswd");
            return (Criteria) this;
        }

        public Criteria andStudentPswdIn(List<String> values) {
            addCriterion("student_pswd in", values, "studentPswd");
            return (Criteria) this;
        }

        public Criteria andStudentPswdNotIn(List<String> values) {
            addCriterion("student_pswd not in", values, "studentPswd");
            return (Criteria) this;
        }

        public Criteria andStudentPswdBetween(String value1, String value2) {
            addCriterion("student_pswd between", value1, value2, "studentPswd");
            return (Criteria) this;
        }

        public Criteria andStudentPswdNotBetween(String value1, String value2) {
            addCriterion("student_pswd not between", value1, value2, "studentPswd");
            return (Criteria) this;
        }

        public Criteria andMajorIsNull() {
            addCriterion("major is null");
            return (Criteria) this;
        }

        public Criteria andMajorIsNotNull() {
            addCriterion("major is not null");
            return (Criteria) this;
        }

        public Criteria andMajorEqualTo(String value) {
            addCriterion("major =", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotEqualTo(String value) {
            addCriterion("major <>", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThan(String value) {
            addCriterion("major >", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThanOrEqualTo(String value) {
            addCriterion("major >=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThan(String value) {
            addCriterion("major <", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThanOrEqualTo(String value) {
            addCriterion("major <=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLike(String value) {
            addCriterion("major like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotLike(String value) {
            addCriterion("major not like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorIn(List<String> values) {
            addCriterion("major in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotIn(List<String> values) {
            addCriterion("major not in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorBetween(String value1, String value2) {
            addCriterion("major between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotBetween(String value1, String value2) {
            addCriterion("major not between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andColledgeIsNull() {
            addCriterion("colledge is null");
            return (Criteria) this;
        }

        public Criteria andColledgeIsNotNull() {
            addCriterion("colledge is not null");
            return (Criteria) this;
        }

        public Criteria andColledgeEqualTo(String value) {
            addCriterion("colledge =", value, "colledge");
            return (Criteria) this;
        }

        public Criteria andColledgeNotEqualTo(String value) {
            addCriterion("colledge <>", value, "colledge");
            return (Criteria) this;
        }

        public Criteria andColledgeGreaterThan(String value) {
            addCriterion("colledge >", value, "colledge");
            return (Criteria) this;
        }

        public Criteria andColledgeGreaterThanOrEqualTo(String value) {
            addCriterion("colledge >=", value, "colledge");
            return (Criteria) this;
        }

        public Criteria andColledgeLessThan(String value) {
            addCriterion("colledge <", value, "colledge");
            return (Criteria) this;
        }

        public Criteria andColledgeLessThanOrEqualTo(String value) {
            addCriterion("colledge <=", value, "colledge");
            return (Criteria) this;
        }

        public Criteria andColledgeLike(String value) {
            addCriterion("colledge like", value, "colledge");
            return (Criteria) this;
        }

        public Criteria andColledgeNotLike(String value) {
            addCriterion("colledge not like", value, "colledge");
            return (Criteria) this;
        }

        public Criteria andColledgeIn(List<String> values) {
            addCriterion("colledge in", values, "colledge");
            return (Criteria) this;
        }

        public Criteria andColledgeNotIn(List<String> values) {
            addCriterion("colledge not in", values, "colledge");
            return (Criteria) this;
        }

        public Criteria andColledgeBetween(String value1, String value2) {
            addCriterion("colledge between", value1, value2, "colledge");
            return (Criteria) this;
        }

        public Criteria andColledgeNotBetween(String value1, String value2) {
            addCriterion("colledge not between", value1, value2, "colledge");
            return (Criteria) this;
        }

        public Criteria andPassedIsNull() {
            addCriterion("passed is null");
            return (Criteria) this;
        }

        public Criteria andPassedIsNotNull() {
            addCriterion("passed is not null");
            return (Criteria) this;
        }

        public Criteria andPassedEqualTo(String value) {
            addCriterion("passed =", value, "passed");
            return (Criteria) this;
        }

        public Criteria andPassedNotEqualTo(String value) {
            addCriterion("passed <>", value, "passed");
            return (Criteria) this;
        }

        public Criteria andPassedGreaterThan(String value) {
            addCriterion("passed >", value, "passed");
            return (Criteria) this;
        }

        public Criteria andPassedGreaterThanOrEqualTo(String value) {
            addCriterion("passed >=", value, "passed");
            return (Criteria) this;
        }

        public Criteria andPassedLessThan(String value) {
            addCriterion("passed <", value, "passed");
            return (Criteria) this;
        }

        public Criteria andPassedLessThanOrEqualTo(String value) {
            addCriterion("passed <=", value, "passed");
            return (Criteria) this;
        }

        public Criteria andPassedLike(String value) {
            addCriterion("passed like", value, "passed");
            return (Criteria) this;
        }

        public Criteria andPassedNotLike(String value) {
            addCriterion("passed not like", value, "passed");
            return (Criteria) this;
        }

        public Criteria andPassedIn(List<String> values) {
            addCriterion("passed in", values, "passed");
            return (Criteria) this;
        }

        public Criteria andPassedNotIn(List<String> values) {
            addCriterion("passed not in", values, "passed");
            return (Criteria) this;
        }

        public Criteria andPassedBetween(String value1, String value2) {
            addCriterion("passed between", value1, value2, "passed");
            return (Criteria) this;
        }

        public Criteria andPassedNotBetween(String value1, String value2) {
            addCriterion("passed not between", value1, value2, "passed");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Double value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Double value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Double value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Double value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Double value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Double> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Double> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Double value1, Double value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Double value1, Double value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andExamTimesIsNull() {
            addCriterion("exam_times is null");
            return (Criteria) this;
        }

        public Criteria andExamTimesIsNotNull() {
            addCriterion("exam_times is not null");
            return (Criteria) this;
        }

        public Criteria andExamTimesEqualTo(Integer value) {
            addCriterion("exam_times =", value, "examTimes");
            return (Criteria) this;
        }

        public Criteria andExamTimesNotEqualTo(Integer value) {
            addCriterion("exam_times <>", value, "examTimes");
            return (Criteria) this;
        }

        public Criteria andExamTimesGreaterThan(Integer value) {
            addCriterion("exam_times >", value, "examTimes");
            return (Criteria) this;
        }

        public Criteria andExamTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("exam_times >=", value, "examTimes");
            return (Criteria) this;
        }

        public Criteria andExamTimesLessThan(Integer value) {
            addCriterion("exam_times <", value, "examTimes");
            return (Criteria) this;
        }

        public Criteria andExamTimesLessThanOrEqualTo(Integer value) {
            addCriterion("exam_times <=", value, "examTimes");
            return (Criteria) this;
        }

        public Criteria andExamTimesIn(List<Integer> values) {
            addCriterion("exam_times in", values, "examTimes");
            return (Criteria) this;
        }

        public Criteria andExamTimesNotIn(List<Integer> values) {
            addCriterion("exam_times not in", values, "examTimes");
            return (Criteria) this;
        }

        public Criteria andExamTimesBetween(Integer value1, Integer value2) {
            addCriterion("exam_times between", value1, value2, "examTimes");
            return (Criteria) this;
        }

        public Criteria andExamTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("exam_times not between", value1, value2, "examTimes");
            return (Criteria) this;
        }

        public Criteria andExamTimeIsNull() {
            addCriterion("exam_time is null");
            return (Criteria) this;
        }

        public Criteria andExamTimeIsNotNull() {
            addCriterion("exam_time is not null");
            return (Criteria) this;
        }

        public Criteria andExamTimeEqualTo(Date value) {
            addCriterion("exam_time =", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeNotEqualTo(Date value) {
            addCriterion("exam_time <>", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeGreaterThan(Date value) {
            addCriterion("exam_time >", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("exam_time >=", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeLessThan(Date value) {
            addCriterion("exam_time <", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeLessThanOrEqualTo(Date value) {
            addCriterion("exam_time <=", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeIn(List<Date> values) {
            addCriterion("exam_time in", values, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeNotIn(List<Date> values) {
            addCriterion("exam_time not in", values, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeBetween(Date value1, Date value2) {
            addCriterion("exam_time between", value1, value2, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeNotBetween(Date value1, Date value2) {
            addCriterion("exam_time not between", value1, value2, "examTime");
            return (Criteria) this;
        }

        public Criteria andIsCheatedIsNull() {
            addCriterion("is_cheated is null");
            return (Criteria) this;
        }

        public Criteria andIsCheatedIsNotNull() {
            addCriterion("is_cheated is not null");
            return (Criteria) this;
        }

        public Criteria andIsCheatedEqualTo(Integer value) {
            addCriterion("is_cheated =", value, "isCheated");
            return (Criteria) this;
        }

        public Criteria andIsCheatedNotEqualTo(Integer value) {
            addCriterion("is_cheated <>", value, "isCheated");
            return (Criteria) this;
        }

        public Criteria andIsCheatedGreaterThan(Integer value) {
            addCriterion("is_cheated >", value, "isCheated");
            return (Criteria) this;
        }

        public Criteria andIsCheatedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_cheated >=", value, "isCheated");
            return (Criteria) this;
        }

        public Criteria andIsCheatedLessThan(Integer value) {
            addCriterion("is_cheated <", value, "isCheated");
            return (Criteria) this;
        }

        public Criteria andIsCheatedLessThanOrEqualTo(Integer value) {
            addCriterion("is_cheated <=", value, "isCheated");
            return (Criteria) this;
        }

        public Criteria andIsCheatedIn(List<Integer> values) {
            addCriterion("is_cheated in", values, "isCheated");
            return (Criteria) this;
        }

        public Criteria andIsCheatedNotIn(List<Integer> values) {
            addCriterion("is_cheated not in", values, "isCheated");
            return (Criteria) this;
        }

        public Criteria andIsCheatedBetween(Integer value1, Integer value2) {
            addCriterion("is_cheated between", value1, value2, "isCheated");
            return (Criteria) this;
        }

        public Criteria andIsCheatedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_cheated not between", value1, value2, "isCheated");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}