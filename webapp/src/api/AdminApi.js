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

export const getInternalLogs = async (adminUid, token = 'aaa') => {
  return await request({
    url: `/api/admin/${adminUid}/log`,
    method: 'GET',
    token,
  });
};

export const getLogs = async (adminUid, userUid, token = 'aaa') => {
  return await request({
    url: `/api/admin/${adminUid}/user/${userUid}/log`,
    method: 'GET',
    token,
  });
};

export const getAllApps = async (adminUid, token = 'aaa') => {
  return await request({
    url: `/api/admin/${adminUid}/app`,
    method: 'GET',
    token,
  });
};

export const getAllNodes = async (adminUid, token = 'aaa') => {
  return await request({
    url: `/api/admin/${adminUid}/node`,
    method: 'GET',
    token,
  });
};

export const getCoworkers = async (adminUid, userUid, token = 'aaa') => {
  return await request({
    url: `/api/admin/${adminUid}/user/${userUid}/coworkers`,
    method: 'GET',
    token,
  });
};

export const getApps = async (adminUid, userUid, token = 'aaa') => {
  return await request({
    url: `/api/admin/${adminUid}/user/${userUid}/app`,
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
  return await request({
    url: `/api/admin/${adminUid}/user/stats?period=${period}`,
    method: 'GET',
    token
  })
};

export const getAppsStats = async (adminUid, period, token = 'aaa') => {
  return await request({
    url: `/api/admin/${adminUid}/app/stats?period=${period}`,
    method: 'GET',
    token
  })
};

const handleError = error => {
  console.log('Handling error ' + error);

};