import request from './request';

export const getAdmin = async (uid, token = 'aaa') => {
  return await request({
    url: `/api/admin/${uid}`,
    method: 'GET',
    token,
  });
};

export const getUsers = async (adminUid, token = 'aaa') => {
  return await request({
    url: `/api/admin/${adminUid}/user`,
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