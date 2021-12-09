/**
 * This is the factory definition for the Student Data Service. This defines how to handle data about Student objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {

    angular
        .module('StudentService', ['cid.app.constants', 'cid.app.variables'])
        .factory('Student', studentFactory);

    studentFactory.$inject = ['$http', 'GLOBAL', 'APP'];

    function studentFactory($http, GLOBAL, APP) {
        var MAX_RETURN = 9999;
        var self = this;
        var url = GLOBAL.API + '/students/';
        var endpoints = {
            current: '/current',
            enrolments: '/enrolments',
            courses: '/courses',
            courseGroups: '/course-groups',
            warnings: '/warnings',
            ilpInterviews: '/ilpInterviews',
            studentYears: '/years',
            specialCategories: '/specialCategories',
            bursary: '/bursary',
            results: '/exam-results',
            correspondence: '/correspondence'
        };

        //Public Interface
        var factory = {
            query: getAll,
            queryPage: getAllByPage,
            get: getById,
            create: create,
            save: save,
            studentYears: studentYears,
            current: getCurrent,
            enrolments: getEnrolments,
            courses: getCourses,
            courseGroups: getCourseGroups,
            warnings: getStudentWarnings,
            ilpInterviews: getILPInterviews,
            specialCategories: getSpecialCategories,
            bursary: getBursary,
            externalResultsArchive: getExternalResultsArchive,
            learningSupport: getLearningSupport,
            attendance: getAttendance,
            admissions: getAdmissions,
            collegeFundPayments: getCollegeFundPayments,
            interimReports: getInterimReports,
            results: getResults,
            idViolations: getIdViolations,
            correspondence: getCorrespondence,
            // Operations
            withdraw: withdraw,
            optionEntries: optionEntries,
            studentAlternativeUci: getAlternativeUcis,
            saveAdmission: saveAdmission,
            getDataSharingOption: getDataSharingOption,
            saveDataSharingOption: saveDataSharingOption
        };

        return factory;

        //Private Interface

        /**
         * This method is used to retrieve all the Room from the API collection.
         *
         * @return {Student} An array of Student objects.
         */
        function getAll(current) {
            if (current === undefined) {
                current = true;
            }
            var request = '';
            // if (current) {
            // 	request += '?current=1&page=0&size=' + MAX_RETURN + '&sort=person.surname,ASC';
            // } else {
            // 	request += 'all/';
            // }
            return $http.get(url + request);
        }

        function getAllByPage(page, size, sort) {
            var request = '?current=1&';
            if (page && page !== 0) {
                request += 'page=' + page + '&';
            }
            if (size && size !== 0) {
                request += 'size=' + size + '&';
            } else {
                request += 'size=' + MAX_RETURN + '&';
            }
            if (sort && sort !== '') {
                request += 'sort=' + sort + '&';
            }
            return $http.get(url + request);
        }

        /**
         * This method is used to retrieve an instance of a Student from the API collection.
         *
         * @param  {int} id of the Student object that is to be retrieved.
         * @return {Student} A Student object as identified by the id.
         */
        function getById(id) {
            if (id !== undefined && id !== null) {
                return $http.get(url + id);
            } else {
                return null;
            }
        }


        /**
         * This method is used to create a new instance of an Student object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Student} room An Student object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Student data is provided then the method returns null.
         */
        function create(student, callback) {
            if (student) {
                return $http.post(url, student).then(function(response) {
                    if (callback) {
                        callback();
                    }
                    return response.data;
                }, function(response) {
                    return {
                        status: response.status,
                        error: response.data
                    };
                });
            } else {
                return null;
            }
        }


        /**
         * This method is used to save changes to an existing Student object.
         *
         * @param  {Student} room An Student object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Student data is provided then the method returns null.
         */
        function save(student, callback) {
            if (student && student.id) {
                return $http.put(url + student.id, student).then(function(response) {
                    if (callback) {
                        callback();
                    }
                    return response.data;
                }, function(response) {
                    return {
                        status: response.status,
                        error: response.data
                    };
                });
            } else {
                return null;
            }
        }

        function studentYears(studentId, yearId, data, callback) {
            if (studentId !== null && yearId !== null) {
                if (data) {
                    return $http.put(url + studentId + endpoints.studentYears + '/' + yearId, data).then(function(response) {
                        if (callback) {
                            callback();
                        }
                        return response.data;
                    }, function(response) {
                        return {
                            status: response.status,
                            error: response.data
                        };
                    });

                } else {
                    return $http.get(url + studentId + endpoints.studentYears + '/' + yearId);
                }
            } else {
                return null;
            }
        }

        function getCurrent() {
            return $http.get(url + endpoints.current);
        }

        /**
         * This method is used to retrieve an instance of a Enrolment of a Student from the API collection.
         *
         * @param  {int} studentId of the Student object that is to be retrieved.
         * @return {Enrolment} An Enrolment object as identified by the studentId.
         */
        function getEnrolments(studentId) {
            year = APP.getYear();
            if (studentId !== undefined && studentId !== null) {
                return $http.get(url + studentId + endpoints.enrolments, {
                    params: {
                        yearId: year.id
                    }
                });
            } else
                return null;
        }

        /**
         * This method is used to retrieve an instance of a Enrolment of a Student from the API collection.
         *
         * @param  {int} studentId of the Student object that is to be retrieved.
         * @return {Enrolment} An Enrolment object as identified by the studentId.
         */
        function getCourses(studentId) {
            year = APP.getYear();
            if (studentId !== undefined && studentId !== null) {
                return $http.get(url + studentId + endpoints.courses, {
                    params: {
                        yearId: year.id
                    }
                });
            } else
                return null;
        }

        /**
         * This method is used to retrieve an instance of a Enrolment of a Student from the API collection.
         *
         * @param  {int} studentId of the Student object that is to be retrieved.
         * @return {Enrolment} An Enrolment object as identified by the studentId.
         */
        function getCourseGroups(studentId) {
            year = APP.getYear();
            if (studentId !== undefined && studentId !== null) {
                return $http.get(url + studentId + endpoints.courseGroups, {
                    params: {
                        yearId: year.id
                    }
                });
            } else
                return null;
        }

        /**
         * This method is used to retrieve an instance of a AttendanceCode of a Student from the API collection.
         * @param  {int} studentId of the Student object that is to be retrieved.
         * @return {AttendanceCode} An AttendanceCode object as identified by the studentId.
         */
        function getAttendance(studentId) {
            year = APP.getYear();
            if (studentId !== undefined && studentId !== null) {
                return $http.get(url + studentId + '/attendance', {
                    params: {
                        yearId: year.id
                    }
                });
            } else {
                return null;
            }
        }

        /**
         * This method is used to retrieve an instance of a InterimReport of a Student from the API collection.
         * @param  {int} studentId of the Student object that is to be retrieved.
         * @return {AttendanceCode} An InterimReport object as identified by the studentId.
         */
        function getInterimReports(studentId) {
            year = APP.getYear();
            if (studentId !== undefined && studentId !== null) {
                return $http.get(url + studentId + '/interimReports', {
                    params: {
                        yearId: year.id
                    }
                });
            } else {
                return null;
            }

        }

        /**
         * This method is used to retrieve an instance of a learningSupport of a Student from the API collection.
         *
         * @param  {int} studentId of the Student object that is to be retrieved.
         * @return {AttendanceCode} An ILPInterview object as identified by the studentId.
         */
        function getLearningSupport(studentId) {
            if (studentId !== undefined && studentId !== null) {
                return $http.get(url + studentId + '/learningSupport');
            } else {
                return null;
            }
        }

        /**
         * This method is used to retrieve an instance of a ILPInterview of a Student from the API collection.
         *
         * @param  {int} studentId of the Student object that is to be retrieved.
         * @return {AttendanceCode} An ILPInterview object as identified by the studentId.
         */
        function getILPInterviews(studentId) {
            if (studentId !== undefined && studentId !== null) {
                return $http.get(url + studentId + endpoints.ilpInterviews);
            } else {
                return null;
            }
        }
        /**
         * This method is used to retrieve an instance of a StudentWarning of a Student from the API collection.
         *
         * @param  {int} studentId of the Student object that is to be retrieved.
         * @return {StudentWarning} An StudentWarning object as identified by the studentId.
         */
        function getStudentWarnings(studentId) {
            year = APP.getYear();
            if (studentId !== undefined && studentId !== null) {
                return $http.get(url + studentId + endpoints.warnings, {
                    params: {
                        yearId: year.id
                    }
                });
            } else {
                return null;
            }
        }

        /**
         * This method is used to retrieve an instance of a StudentWarning of a Student from the API collection.
         *
         * @param  {int} studentId of the Student object that is to be retrieved.
         * @return {StudentWarning} An StudentWarning object as identified by the studentId.
         */
        function getAdmissions(studentId) {
            if (studentId !== undefined && studentId !== null) {
                return $http.get(url + studentId + '/admissions');
            } else {
                return null;
            }
        }
        /**
         * This method is used to retrieve an instance of a SpecialCategory  of a Student from the API collection.
         *
         * @param  {int} studentId of the Student object that is to be retrieved.
         * @return {SpecialCategory } An SpecialCategory  object as identified by the studentId.
         */
        function getSpecialCategories(studentId) {
            if (studentId !== undefined && studentId !== null) {
                return $http.get(url + studentId + endpoints.specialCategories);
            } else {
                return null;
            }
        }
        /**
         * This method is used to retrieve an instance of a CollegeFundPayment  of a Student from the API collection.
         *
         * @param  {int} studentId of the Student object that is to be retrieved.
         * @return {CollegeFundPayment } An CollegeFundPayment  object as identified by the studentId.
         */
        function getCollegeFundPayments(studentId) {
            if (studentId !== undefined && studentId !== null) {
                return $http.get(url + studentId + '/collegeFundPayments');
            } else {
                return null;
            }
        }
        /**
         * This method is used to retrieve an instance of a CollegeFundPayment  of a Student from the API collection.
         *
         * @param  {int} studentId of the Student object that is to be retrieved.
         * @return {CollegeFundPayment } An CollegeFundPayment  object as identified by the studentId.
         */
        function getBursary(studentId) {
            year = APP.getYear();
            if (studentId !== undefined && studentId !== null) {
                return $http.get(url + studentId + endpoints.bursary, {
                    params: {
                        yearId: year.id
                    }
                });
            } else {
                return null;
            }
        }
        /**
         * This method is used to retrieve an instance of a StudentBursary   of a Student from the API collection.
         *
         * @param  {int} studentId of the Student object that is to be retrieved.
         * @return {StudentBursary  } An StudentBursary object as identified by the studentId.
         */
        function getExternalResultsArchive(studentId) {
            if (studentId !== undefined && studentId !== null) {
                return $http.get(url + studentId + '/externalResults');
            } else {
                return null;
            }
        }

        /**
         * This method is used to retrieve an array of exam results of a Student from the API.
         *
         * @param  {Integer} studentId The studentId of the student to retireve the results for
         * @return {promise}           A promise that will be used to retireve the results data
         */
        function getResults(studentId) {
            if (studentId !== undefined && studentId !== null) {
                return $http.get(url + studentId + endpoints.results);
            } else {
                return null;
            }
        }

        /**
         * This method is used to withdraw a Student from a specified academic year.
         *
         * @param  {int} studentId of the Student object that is to be retrieved.
         * @return {Student} An Student object as identified by the studentId.
         */
        function withdraw(studentId, withdrawalRequest) {
            if (studentId !== null && withdrawalRequest) {
                return $http.post(url + studentId + '/withdraw', withdrawalRequest);
            } else {
                return null;
            }
        }


        /**
         * This method is used to retrieve an array of student exam options of a Student from the API.
         *
         * @param  {Integer} studentId The studentId of the student to retireve the results for
         * @return {OptionEntries}
         */
        function optionEntries(studentId) {
            year = APP.getYear();
            if (studentId !== undefined && studentId !== null) {
                return $http.get(url + studentId + '/optionEntries', {
                    params: {
                        yearId: year.id
                    }
                });
            } else {
                return null;
            }
        }

        /**
         * This methods is used to retrieve an array of alternative UCIs of a Student from the API.
         *
         * @param  {Integer} studentId The studentId of the student to retireve the results for
         * @return {Array}           an array of alternative UCIs
         */
        function getAlternativeUcis(studentId) {
            if (studentId !== undefined && studentId !== null) {
                return $http.get(url + studentId + '/alternative-ucis');
            } else {
                return null;
            }
        }

        /**
         * This methods is used to update details of Admission
         *
         * @param  {Integer} studentId The studentId of the student to retireve the results for
         * @return {Array}           an array of alternative UCIs
         */
        function saveAdmission(studentAdmission, callback) {
            if (studentAdmission && studentAdmission.id) {
                return $http.put(url + studentAdmission.id + '/admissions', studentAdmission).then(function(response) {
                    if (callback) {
                        callback();
                    }
                    return response.data;
                }, function(response) {
                    return {
                        status: response.status,
                        error: response.data
                    };
                });
            } else {
                return null;
            }
        }

        /**
         * This methods is used to retrieve details of Data Sharing Options of a Student from the API.
         *
         * @param  {Integer} studentId The studentId of the student to retireve the results for
         * @return {Array}           an array of alternative UCIs
         */
        function getDataSharingOption(studentId) {
            if (studentId !== undefined && studentId !== null) {
                return $http.get(url + studentId + '/dataSharingOptions');
            } else {
                return null;
            }

        }

        /**
         * This methods is used to retrieve details of Data Sharing Options of a Student from the API.
         *
         * @param  {Integer} studentId The studentId of the student to retireve the results for
         * @return {Array}           an array of alternative UCIs
         */
        function getIdViolations(studentId) {
            if (studentId !== undefined && studentId !== null) {
                return $http.get(url + studentId + '/id-violations');
            } else {
                return null;
            }

        }

        /**
         * This method is used to retrieve an instance of a Correspondence from the API collection.
         *
         * @param  {int} studentId of the Correspondence object that is to be retrieved.
         * @return {Correspondence} An Correspondence object as identified by the studentId.
         */
        function getCorrespondence(studentId) {
            if (studentId) {
                return $http.get(url + studentId + '/correspondence');
            } else {
                return null;
            }
        }

        function saveDataSharingOption(dataSharingOption) {
            if (dataSharingOption && dataSharingOption.studentId) {
                return $http.put(url + dataSharingOption.studentId + '/dataSharingOptions', dataSharingOption).then(function(response) {
                    if (callback) {
                        callback();
                    }
                    return response.data;
                }, function(response) {
                    return {
                        status: response.status,
                        error: response.data
                    };
                });
            } else {
                return null;
            }
        }

    }

})();
