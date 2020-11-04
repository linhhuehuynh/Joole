export const updatedObject = (originalObject, updatedProperties) => {
    return {
        ...originalObject,
        ...updatedProperties
    };
};
