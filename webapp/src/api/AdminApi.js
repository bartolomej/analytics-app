import request from './request';


// MULTIPLE RESOURCE REQUESTS

export const getUsers = async (adminUid, token = 'aaa') => {
  return await request({
    url: `/api/admin/${adminUid}/user`,
    method: 'GET',
    token,
  });
};

export const getRecentLogs = async (adminUid, limit, token = 'aaa') => {
  return await request({
    url: `/api/admin/${adminUid}/log?limit=${limit}`,
    method: 'GET',
    token,
  });
};

export const getLogs = async (adminUid, token = 'aaa') => {
  return await request({
    url: `/api/admin/${adminUid}/log`,
    method: 'GET',
    token,
  });
};

export const getApps = async (adminUid, token = 'aaa') => {
  return await request({
    url: `/api/admin/${adminUid}/app`,
    method: 'GET',
    token,
  });
};


// SINGLE RESOURCE REQUESTS

export const getAdmin = async (adminUid, token = 'aaa') => {
  return await request({
    url: `/api/admin/${adminUid}`,
    method: 'GET',
    token,
  });
};

export const getUser = async (adminUid, userUid, token = 'aaa') => {
  return await request({
    url: `/api/admin/${adminUid}/user/${userUid}`,
    method: 'GET',
    token,
  });
};


// STATISTICS REQUESTS

export const getInternalLogStats = async (adminUid, period, token = 'aaa') => {
  return await request({
    url: `/api/admin/${adminUid}/log/stats?period=${period}`,
    method: 'GET',
    token,
  });
};

export const getUserRegistrationStats = async (adminUid, period, token = 'aaa') => {
  // TODO: call api
};


const handleError = error => {
  console.log('Handling error ' + error);

};