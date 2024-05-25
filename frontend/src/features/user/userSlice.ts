import { createAsyncThunk, createSlice } from '@reduxjs/toolkit';
import axiosClient from '../../api';
import { IGetUser, IUser } from '../../interfaces';

interface UserState {
    user: IUser | undefined;
    loading: boolean;
    error: string | null;
}

const initialState: UserState = {
    user: undefined,
    loading: false,
    error: null,
};

const getUser = createAsyncThunk('getUser', async (data: IGetUser) => {
    const res = await axiosClient.get(`http://localhost:4003/api/v1/students-service/${data.mssv}`);

    return res.data.data;
});

const userSlice = createSlice({
    name: 'user',
    initialState,
    reducers: {},
    extraReducers: (builder) => {
        builder.addCase(getUser.pending, (state) => {
            state.loading = true;
        });

        builder.addCase(getUser.fulfilled, (state, action) => {
            state.loading = false;
            state.user = action.payload;
        });

        builder.addCase(getUser.rejected, (state, action) => {
            state.loading = false;
            state.error = action.error.message || 'Something went wrong';
        });
    },
});

export default userSlice.reducer;
export { getUser };
